package com.sonu.quizapp.controller;

import com.sonu.quizapp.entity.Question;
import com.sonu.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
     @Autowired
     public final QuestionService questionservice;

     public QuestionController(QuestionService questionservice){
         this.questionservice = questionservice;
     }

    @GetMapping("/allQuestions")
    public List<Question> getAllQuestions(){
        return questionservice.getAllquestions();
    }

    @GetMapping("/category/{category}")
    public List<Question> getQuestionByCategory(@PathVariable String category){
         return questionservice.getQuestionbyCategory(category);
    }

    @GetMapping("/id/{id}")
    public Question GetQuestionById(@PathVariable long id){
         return questionservice.getQuestionbyId(id);
    }

    @GetMapping("/level/{level}")
    public List<Question> getQuestionByLevel( String level){
         return questionservice.getQuestionByLevel(level);
    }

    @PostMapping("add")
    public String addQuestion(@RequestBody Question question){
         return questionservice.addQuestion(question);
    }
}
