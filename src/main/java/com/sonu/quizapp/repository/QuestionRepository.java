package com.sonu.quizapp.repository;

import com.sonu.quizapp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {


    List<Question>findByCategory(String category);

   List <Question> findById(long id);

    List<Question> findByLevel(String level);

    @Query(value = "SELECT * FROM Questions q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);

}
