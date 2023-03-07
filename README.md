# Survey API
Spring Boot 이용한 Survey API  

## 프로젝트 개발환경

- Language
  - jdk 11
- Framework
  - SpringBoot 2.7.3
- ORM
  - JPA
- DB
  - Mysql

## 코드 실행

```
$ cd <프로젝트 디렉터리>/demo
$ ./gradlew bootRun
```

## REST API

### Survey

| Method     | URI                               | Action                                                  |
|------------|-----------------------------------|---------------------------------------------------------|
| `GET`      | `selectQuestion`                  | `App\Http\Controllers\SurveyController@selectQuestion`  |
| `POST`     | `insertAnswer`                    | `App\Http\Controllers\SurveyController@insertAnswer`    |
| `POST`     | `insertSurvey`                    | `App\Http\Controllers\SurveyController@insertSurvey`    |


