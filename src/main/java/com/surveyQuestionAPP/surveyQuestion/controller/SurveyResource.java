package com.surveyQuestionAPP.surveyQuestion.controller;

import com.surveyQuestionAPP.surveyQuestion.modal.Question;
import com.surveyQuestionAPP.surveyQuestion.modal.Survey;
import com.surveyQuestionAPP.surveyQuestion.service.SurveyService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class SurveyResource {
    @Autowired
    private SurveyService surveyService ;

    @GetMapping("/surveys")
    public List<Survey> retrieveAll(){
        return surveyService.retrieveAll();
    }

    @GetMapping("/surveys/{surveyId}")
    public Survey retrieveSurveyById(@PathVariable String surveyId){
        Survey survey = surveyService.retrieveSurveyById(surveyId);
        if(survey==null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return survey;
    }

    @GetMapping("/surveys/{surveyId}/questions")
    public List<Question> retrieveAllSurveyQuestions(@PathVariable String surveyId){
        List<Question> questions = surveyService.retrieveAllSurveyQuestions(surveyId);
        if(questions==null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return questions;
    }

    @GetMapping("/surveys/{surveyId}/questions/{questionId}")
    public Question retrieveSpecificQuestion(@PathVariable String surveyId,@PathVariable String questionId){
        Question question = surveyService.retrieveSpecificQuestion(surveyId,questionId);
        if(question==null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return question;
    }
    @DeleteMapping("/surveys/{surveyId}/questions/{questionId}")
    public ResponseEntity<Object> DeleteSpecificQuestion(@PathVariable String surveyId, @PathVariable String questionId){
       surveyService.deleteSurveyQuestion(surveyId,questionId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/surveys/{surveyId}/questions/{questionId}")
    public ResponseEntity<Object> UpdateSpecificQuestion(@PathVariable String surveyId, @PathVariable String questionId,@RequestBody Question question){
        surveyService.updateSurveyQuestion(surveyId,questionId,question);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/surveys/{surveyId}")
    public ResponseEntity<Object> addNewSurveyQuestion(@PathVariable String surveyId, @RequestBody Question question){
        String questionId = surveyService.addNewSurveyQuestion(surveyId,question);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{questionId}").buildAndExpand(questionId).toUri();
        return ResponseEntity.created(location).build();
    }

//    @PostMapping("/surveys/{surveyId}/questions")
//    public ResponseEntity<Object> addNewSurveyQuestions(@PathVariable String surveyId,@RequestBody Question question){
//        String questionId = surveyService.addNewSurveyQuestion(surveyId,question);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().
//
//    }
}
