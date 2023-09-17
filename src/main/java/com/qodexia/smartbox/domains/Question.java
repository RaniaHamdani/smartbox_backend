package com.qodexia.smartbox.domains;

import com.qodexia.smartbox.enums.Difficulty;
import com.qodexia.smartbox.enums.Seniority;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.Duration;
import java.util.Set;
@Entity
@Table(name = "question")

public class Question extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_seq")
    private Long id;
    @Column(name = "question_title")
    private String title;
    @Column(name = "question_body")
    private String body;

    @ElementCollection(targetClass = Seniority.class)
    @CollectionTable(name = "question_seniority", joinColumns = @JoinColumn(name = "question_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "question_seniority")
    private Set<Seniority> seniorities;
    @Column(name = "question_technology")
    private String technology;
    @Column(name = "question_difficulty")
    private Difficulty difficulty;
    @Column(name = "question_score")
    private Integer score;
    @Column(name = "question_duration")
    private String duration;
    @Column(name = "question_answer1")
    private String answer1;
    @Column(name = "question_answer1_state")
    private String answer1State;
    @Column(name = "question_answer2")
    private String answer2;
    @Column(name = "question_answer2_state")
    private String answer2State;
    @Column(name = "question_answer3")
    private String answer3;
    @Column(name = "question_answer3_state")
    private String answer3State;
    @Column(name = "question_answer4")
    private String answer4;
    @Column(name = "question_answer4_state")
    private String answer4State;
    @Column(name = "question_answer5")
    private String answer5;
    @Column(name = "question_answer5_state")

    private String answer5State;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer1State() {
        return answer1State;
    }

    public void setAnswer1State(String answer1State) {
        this.answer1State = answer1State;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer2State() {
        return answer2State;
    }

    public void setAnswer2State(String answer2State) {
        this.answer2State = answer2State;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer3State() {
        return answer3State;
    }

    public void setAnswer3State(String answer3State) {
        this.answer3State = answer3State;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getAnswer4State() {
        return answer4State;
    }

    public void setAnswer4State(String answer4State) {
        this.answer4State = answer4State;
    }

    public String getAnswer5() {
        return answer5;
    }

    public void setAnswer5(String answer5) {
        this.answer5 = answer5;
    }

    public String getAnswer5State() {
        return answer5State;
    }

    public void setAnswer5State(String answer5State) {
        this.answer5State = answer5State;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Set<Seniority> getSeniorities() {
        return seniorities;
    }

    public void setSeniorities(Set<Seniority> seniorities) {
        this.seniorities = seniorities;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
