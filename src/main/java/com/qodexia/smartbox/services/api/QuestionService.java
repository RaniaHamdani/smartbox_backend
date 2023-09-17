package com.qodexia.smartbox.services.api;

import com.qodexia.smartbox.models.QuestionDto;

import java.util.List;

public interface QuestionService {

    // create question
    // update question
    // get question by id
    // delete question by id
    // get all questions
    //generate code for create question

    QuestionDto createQuestion(QuestionDto questionDto);
    QuestionDto updateQuestion(QuestionDto questionDto);
    QuestionDto getQuestionById(Long id);

    List<QuestionDto> getAllQuestions();

    QuestionDto updateQuestionBy(QuestionDto questionDto);
    void deleteQuestionById(Long id);




}
