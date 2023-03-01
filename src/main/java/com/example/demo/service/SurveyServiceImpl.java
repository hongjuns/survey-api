package com.example.demo.service;

import com.example.demo.model.AnswerEntity;
import com.example.demo.model.SurveyEntity;
import com.example.demo.persistence.AnswerRepository;
import com.example.demo.persistence.SurveyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

@Slf4j
@Service
public class SurveyServiceImpl implements SurveyService {
    private final SurveyRepository surveyRepository;
    private final AnswerRepository answerRepository;

    public SurveyServiceImpl(SurveyRepository surveyRepository,AnswerRepository answerRepository) {
        this.surveyRepository = surveyRepository;
        this.answerRepository = answerRepository;
    }

    @Override
    public SurveyEntity selectQuestion(SurveyEntity entity) {
        //Validations
        validata(entity);
        Optional<SurveyEntity> original = Optional.ofNullable(surveyRepository.findBySecretKey(entity.getSecretKey()));
        if(original.isPresent()){
            SurveyEntity surveyEntity = original.get();
            return surveyEntity;
        }else {
            throw new RuntimeException("Survey not exist");
        }
    }
    @Transactional
    @Override
    public AnswerEntity insertAnswer(AnswerEntity answerEntity) {
        Optional<SurveyEntity> original = Optional.ofNullable(surveyRepository.findBySecretKey(answerEntity.getSecretKey()));
        if(original.isPresent()){
            SurveyEntity surveyEntity = original.get();
            AnswerEntity saveAnswer =  answerRepository.save(answerEntity);
            surveyRepository.updateAnswer(saveAnswer.getSeq(),surveyEntity.getSurveySeq());
            return saveAnswer;
        }else {
            throw new RuntimeException("Survey not exist");
        }
    }

    @Override
    public SurveyEntity insertSurvey(SurveyEntity surveyEntity) {
        try{
            surveyEntity.setSecretKey(encrypt(surveyEntity.getUserNm()));
            return surveyRepository.save(surveyEntity);
        }
        catch (Exception e){
            log.error(" insertSurvey error {}" + e.getMessage() ,e );
            throw new RuntimeException("insertSurvey error");
        }
    }

    private void validata(SurveyEntity entity){
        if (entity.getSecretKey() == null){
            log.warn("Unknown Key.");
            throw new RuntimeException("Unknown Key.");
        }
    }
    private String encrypt (String text) throws Exception {
        String alg = "AES/CBC/PKCS5Padding";
        String key = "01234567890123456789012345678901";
        String iv = key.substring(0, 16); // 16byte

        Cipher cipher = Cipher.getInstance(alg);
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec);

        byte[] encrypted = cipher.doFinal(text.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encrypted);
    }
}
