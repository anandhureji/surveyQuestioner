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
public class Survey {

    private String id;
    private String title;
    private String description;
    private List<Question> questions;

}
