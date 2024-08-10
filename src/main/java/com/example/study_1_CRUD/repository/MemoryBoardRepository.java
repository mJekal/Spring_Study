package com.example.study_1_CRUD.repository;

import com.example.study_1_CRUD.domain.Board;

import java.util.*;

public class MemoryBoardRepository implements BoardRepository{

    private static Map<Long,Board> boardList = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Board save(Board board) {
        board.setId(++sequence);
        boardList.put(board.getId(),board);
        return board;
    }

    @Override
    public Optional<Board> findById(Long id) {
        return Optional.ofNullable(boardList.get(id));
    }

    @Override
    public Optional<Board> findByTitle(String title) {
        return boardList.values().stream().filter(board->board.getTitle().equals(title)).findAny();
    }

    @Override
    public List<Board> findAll() {
        return new ArrayList<>(boardList.values());
    }
}
