package com.qodexia.smartbox.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AnswerDto {
    private Long id;
    private String body;
    private Boolean State;
    private QuestionDto questionDto;
}
