package com.qodexia.smartbox.controllers;

import com.qodexia.smartbox.mapper.QuestionMapper;
import com.qodexia.smartbox.models.EntrepriseDto;
import com.qodexia.smartbox.models.QuestionDto;
import com.qodexia.smartbox.services.api.QuestionService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


// @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
@RestController
@CrossOrigin
@RequestMapping("/questions")

public class QuestionController {
    @Autowired
    private final QuestionService questionService;
    @Autowired
    private final QuestionMapper questionMapper;

    public QuestionController(QuestionService questionService, QuestionMapper questionMapper) {
        this.questionService = questionService;
        this.questionMapper = questionMapper;
    }
    @PostMapping
    public ResponseEntity<QuestionDto> createQuestion(@RequestBody @Valid QuestionDto questionDto) {
        QuestionDto savedQuestionDto = questionService.createQuestion(questionDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedQuestionDto);
    }

    @GetMapping("/{id}")
    //get a question by id
    public ResponseEntity<QuestionDto> getQuestionById(@PathVariable Long id) {
        QuestionDto questionDto = questionService.getQuestionById(id);
        if (questionDto != null) {
            return ResponseEntity.ok(questionDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    // get all questions
    public ResponseEntity<List<QuestionDto>> getAllQuestions() {
        List<QuestionDto> questionDtos = questionService.getAllQuestions();
        return ResponseEntity.ok(questionDtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestionById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<QuestionDto> updateQuestion(
            @PathVariable Long id, @RequestBody @Valid QuestionDto questionDto) {
        questionDto.setId(id);
        QuestionDto updatedQuestionDto = questionService.createQuestion(questionDto);
        if (updatedQuestionDto != null) {
            return ResponseEntity.ok(updatedQuestionDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

