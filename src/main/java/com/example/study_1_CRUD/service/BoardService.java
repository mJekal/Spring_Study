package com.example.study_1_CRUD.service;

import com.example.study_1_CRUD.domain.Board;
import com.example.study_1_CRUD.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import jakarta.transaction.Transactional;

import java.util.List;

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

    public void modifyBoard(Long id, String title, String content) {
        Board board = boardRepository.findOne(id);
        if (board != null) {
            board.setTitle(title);
            board.setContent(content);
            boardRepository.save(board);
        }
    }

    public void deleteBoard(Long boardId) {
        boardRepository.deleteById(boardId);
    }

    public List<Board> findBoards() {
        return boardRepository.findAll();
    }

    public Board findOne(Long boardId) {
        return boardRepository.findOne(boardId);
    }

    public Page<Board> findAll(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }
}
