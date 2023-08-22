package com.rohit.questionservice.dao;


import com.rohit.questionservice.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);

    @Query(value = "SELECT q.id FROM question q WHERE q.categoryName =:categoryName ORDER BY RANDOM() LIMIT :numQuestion",nativeQuery = true)
    List<Integer> findRandomQuestionByCategory(String categoryName , Integer numQuestion);
}
