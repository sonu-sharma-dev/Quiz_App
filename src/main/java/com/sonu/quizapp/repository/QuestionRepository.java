package com.sonu.quizapp.repository;

import com.sonu.quizapp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {


    List<Question>findByCategory(String category);

   List <Question> findById(long id);

    List<Question> findByLevel(String level);


}
