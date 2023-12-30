package com.sonu.quizapp.service;

import com.sonu.quizapp.entity.Question;
import com.sonu.quizapp.entity.QuestionWrapper;
import com.sonu.quizapp.entity.Quiz;
import com.sonu.quizapp.repository.QuestionRepository;
import com.sonu.quizapp.repository.QuizRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class QuizService {
    final
    QuizRepository quizRepository;
    final
    QuestionRepository questionRepository;

    public QuizService(QuizRepository quizRepository, QuestionRepository questionRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
    }


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions=questionRepository.findRandomQuestionsByCategory(category,numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
       Optional <Quiz> quiz=quizRepository.findById(id);
        List<Question> questionsFromDb=quiz.get().getQuestions();
        List<QuestionWrapper> questionForUsers=new ArrayList<>();
        for (Question q: questionsFromDb){
            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionText(),q.getOptionA(),q.getOptionB(),q.getOptionC(),q.getOptionD());
            questionForUsers.add(qw);
        }

        return new ResponseEntity<>(questionForUsers,HttpStatus.OK);
    }
}
