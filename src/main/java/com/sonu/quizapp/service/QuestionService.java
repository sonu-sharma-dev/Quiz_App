package com.sonu.quizapp.service;
import com.sonu.quizapp.entity.Question;
import com.sonu.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    public final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }

    public  List<Question> getAllquestions() {
      return questionRepository.findAll();

    }

    public List<Question> getQuestionbyCategory(String category) {
        return questionRepository.findByCategory(category);
    }

    public Question getQuestionbyId(long id) {
        return questionRepository.findById(id);
    }

    public List<Question> getQuestionByLevel(String level) {
        return questionRepository.findByLevel(level);
    }

    public String addQuestion(Question question) {
       questionRepository.save(question);
        return "Success";
    }
}
