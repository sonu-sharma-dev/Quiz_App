package com.sonu.quizapp.entity;


import jakarta.persistence.Column;
import lombok.Data;

@Data
public class QuestionWrapper {

    @Column(name = "id")
    private Long id;
    @Column(name = "question_text")
    private String questionText;
    @Column(name = "option_a")
    private String optionA;
    @Column(name = "option_b")
    private String optionB;
    @Column(name = "option_c")
    private String optionC;
    @Column(name = "option_d")
    private String optionD;


    public QuestionWrapper(Long id, String optionA, String optionB, String optionC, String optionD) {
    }
}
