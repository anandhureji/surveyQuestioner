package com.survey.surveyquestioner.controller;

import com.survey.surveyquestioner.service.SurveyService;
import com.survey.surveyquestioner.survey.Survey;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class SurveyResource {

    private SurveyService surveyService;

    @GetMapping("/surveys")
    public List<Survey> retrieveAll(){
        return surveyService.retrieveAllSurvey();
    }
}
