package com.qodexia.smartbox.mapper;


import com.qodexia.smartbox.domains.Adresse;
import com.qodexia.smartbox.domains.Question;
import com.qodexia.smartbox.models.AdresseDTO;
import com.qodexia.smartbox.models.QuestionDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {UserMapper.class})

public interface QuestionMapper {

    Question questionDtoToQuestion(QuestionDto questionDto);

    QuestionDto questionToQuestionDto(Question question);

    List<QuestionDto> questionListToQuestionDtoList(List<Question> questions);
    List<Question> questionDtoListToQuestionList (List<QuestionDto> questions);

}