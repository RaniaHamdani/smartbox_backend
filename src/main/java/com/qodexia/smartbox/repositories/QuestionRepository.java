package com.qodexia.smartbox.repositories;

import com.qodexia.smartbox.domains.Question;
import com.qodexia.smartbox.models.QuestionDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    Question getQuestionById(Long id);
    void deleteQuestionById(Long id);

}
