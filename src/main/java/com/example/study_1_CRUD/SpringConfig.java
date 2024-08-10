package com.example.study_1_CRUD;

import com.example.study_1_CRUD.repository.BoardRepository;
import com.example.study_1_CRUD.repository.JpaBoardRepository;
import com.example.study_1_CRUD.service.BoardService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em){
        this.em = em;
    }
    @Bean
    public BoardService boardService(){
        return new BoardService(boardRepository());
    }

    @Bean
    public BoardRepository boardRepository(){
        return new JpaBoardRepository(em);
    }
}
