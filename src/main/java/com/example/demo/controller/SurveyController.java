package com.example.demo.controller;

import com.example.demo.dto.AnswerDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.SurveyDTO;
import com.example.demo.exception.CustomizedResponseHandler;
import com.example.demo.model.Answer;
import com.example.demo.model.Survey;
import com.example.demo.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/survey")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @GetMapping("/{id}")
    public ResponseEntity<?> selectSurvey (@PathVariable int id) {

        try{
            Survey survey = surveyService.findOne(id);

            if (survey == null){
                throw new CustomizedResponseHandler.SurveyNotFoundException(String.format("ID [%s} Not Found" ,id));
            }

            SurveyDTO dto = surveyService.findSurveyItem(survey);
            return ResponseEntity.ok().body(dto);

        }catch (Exception e){
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> insertAnswer (@PathVariable int id, @RequestBody SurveyDTO answerDTO) {

        try{
            Survey survey = surveyService.findOne(id);

            if (survey == null){
                throw new CustomizedResponseHandler.SurveyNotFoundException(String.format("ID [%s} Not Found" ,id));
            }
            //DTO -> Entity 변환
            List<Answer> answersEntity = answerDTO.getAnswerDTOList()
                    .stream()
                    .map(item -> AnswerDTO.toEntity(item))
                    .collect(Collectors.toList());

            surveyService.saveAnswer(answersEntity);
            return ResponseEntity.ok().body("등록이 완료되었습니다.");

        }catch (Exception e){
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

}
