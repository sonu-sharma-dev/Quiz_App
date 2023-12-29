package com.sonu.quizapp.service;
import com.sonu.quizapp.entity.Question;
import com.sonu.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    public final QuestionRepository questionRepository;


    public QuestionService(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }

    public ResponseEntity<List<Question>> getAllquestions() {
        try {
            return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity< List<Question>> getQuestionbyCategory(String category) {
        try {
            return new ResponseEntity<>(questionRepository.findByCategory(category), HttpStatus.OK);
        } catch (Exception e){
        e.printStackTrace();
    }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionbyId(long id) {
        try {
            return new  ResponseEntity<>(questionRepository.findById(id), HttpStatus.OK);
        } catch (Exception e){
        e.printStackTrace();
    }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity< List<Question>> getQuestionByLevel(String level) {
        try {

            return new ResponseEntity<>(questionRepository.findByLevel(level), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity <String> addQuestion(Question question) {
        try {
            questionRepository.save(question);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error!!", HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> deleteQuestionByid(long id) {
        try {
            questionRepository.deleteById((int) id);
            return new ResponseEntity<>("Success",HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error!!", HttpStatus.BAD_REQUEST);

    }


    public String updateQuestion(Question question) {
//        questionRepository.f/indById(id);
        questionRepository.save(question);
        return "Successfully Updated";
    }
}
