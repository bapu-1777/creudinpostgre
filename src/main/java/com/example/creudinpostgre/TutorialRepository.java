package com.example.creudinpostgre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

    List<Tutorial> findByPublished(boolean published);
    List<Tutorial> findByTitleContaining(String title);

    @Transactional
    @Query(value = "SELECT * FROM public.tutorials",nativeQuery = true)
    List<Tutorial> findAllActiveUsers();

}