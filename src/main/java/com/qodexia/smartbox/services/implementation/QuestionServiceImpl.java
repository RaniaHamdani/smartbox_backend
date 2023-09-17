package com.qodexia.smartbox.services.implementation;

import com.qodexia.smartbox.domains.Entreprise;
import com.qodexia.smartbox.domains.Question;
import com.qodexia.smartbox.exceptions.RessourceNotFoundException;
import com.qodexia.smartbox.mapper.QuestionMapper;
import com.qodexia.smartbox.models.EntrepriseDto;
import com.qodexia.smartbox.models.QuestionDto;
import com.qodexia.smartbox.repositories.QuestionRepository;
import com.qodexia.smartbox.services.api.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionMapper questionMapper;
    @Override
    public QuestionDto createQuestion(QuestionDto questionDto) {
        Question questionToCreate =  questionMapper.questionDtoToQuestion(questionDto);
        return questionMapper.questionToQuestionDto(questionRepository.save(questionToCreate));
    }
    @Override
    public QuestionDto updateQuestion(QuestionDto questionDto) {
        return null;
    }

    @Override
    //getquestionby id
    @Transactional(readOnly = true)
    public QuestionDto getQuestionById(Long id) {
        return questionMapper.questionToQuestionDto(questionRepository.getQuestionById(id));
    }



    @Override
    public void deleteQuestionById(Long id) {
        questionRepository.delete(questionRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("La question n'existe pas")));
    }

    @Override

    public QuestionDto updateQuestionBy(QuestionDto questionDto) {
        Question question = questionRepository.findById(questionDto.getId()).orElseThrow(() -> new RessourceNotFoundException("La question n'existe pas"));
        question.setBody(questionDto.getBody());
        question.setDuration(questionDto.getDuration());
        question.setScore(questionDto.getScore());
        question.setTitle(questionDto.getTitle());
        question.setSeniorities(questionDto.getSeniorities());
        question.setTechnology(questionDto.getTechnology());
        return questionMapper.questionToQuestionDto(questionRepository.save(question));

    }

    @Override
    @Transactional(readOnly = true)
    public List<QuestionDto> getAllQuestions() {

        return questionMapper.questionListToQuestionDtoList(questionRepository.findAll());
    }

}

