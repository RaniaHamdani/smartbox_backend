package com.qodexia.smartbox.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "answer")

public class Answer extends AuditModel {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "answer_body")
    @Size(min = 1, max = 150, message = "The answer should be less than 150 characters")
    @NotNull(message = "No answer text provided.")
    private String body;
    @Column(name = "answer_state")
    private Boolean state;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;
}
