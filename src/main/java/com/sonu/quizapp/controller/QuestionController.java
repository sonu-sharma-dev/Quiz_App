package com.sonu.quizapp.controller;

import com.sonu.quizapp.entity.Question;
import com.sonu.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionservice.getAllquestions();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity< List<Question>> getQuestionByCategory(@PathVariable String category){
         return questionservice.getQuestionbyCategory(category);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<List<Question>> getQuestionById(@PathVariable long id){
         return questionservice.getQuestionbyId(id);
    }

    @GetMapping("/level/{level}")
    public ResponseEntity<List<Question>> getQuestionByLevel( String level){
         return questionservice.getQuestionByLevel(level);
    }

    @PostMapping("add")
    public ResponseEntity <String> addQuestion(@RequestBody Question question){
         return questionservice.addQuestion(question);
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity <String> deleteQuestionById(@RequestBody @PathVariable long id) {

            return questionservice.deleteQuestionByid(id);
    }

    @PutMapping("/update")
    public String updateQuestion(@RequestBody Question question  ){
         return questionservice.updateQuestion(question);
    }
}
