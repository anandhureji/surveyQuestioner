package com.survey.surveyquestioner.survey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Question {

    private String id;
    private String description;
    private List<String> options;
    private String correctanswers;



}
