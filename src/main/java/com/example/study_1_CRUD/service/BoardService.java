package com.example.study_1_CRUD.service;

import com.example.study_1_CRUD.domain.Board;
import com.example.study_1_CRUD.repository.BoardRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class BoardService {
    private final BoardRepository boardRepository;
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
}

        public Long join(Board board) {
        boardRepository.save(board);
        return board.getId();
    }

    public List<Board> findBoards() {
        return boardRepository.findAll();
    }

    public Optional<Board> findOne(Long boardId) {
        return boardRepository.findById(boardId);
    }
}
