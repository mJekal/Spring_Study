package com.example.study_1_CRUD.repository;
import com.example.study_1_CRUD.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    Board save(Board board);
    Optional<Board> findById(Long id);
    Optional<Board> findByTitle(String title);
    Board findOne(Long id);
    List<Board> findAll();
    void deleteById(Long id);
    Page<Board> findAll(Pageable pageable);
}
