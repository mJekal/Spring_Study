package com.example.study_1_CRUD.controller;

import com.example.study_1_CRUD.domain.Board;
import com.example.study_1_CRUD.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/boards/new")
    public String createForm() {
        return "boards/createBoardForm";
    }

    @PostMapping("/boards/new")
    public String create(BoardForm form) {
        Board board = new Board();
        board.setTitle(form.getTitle());
        board.setContent(form.getContent());
        boardService.join(board);
        return "redirect:/";
    }

    @GetMapping("/boards")
    public String list(Model model) {
        List<Board> boards = boardService.findBoards();
        model.addAttribute("boards", boards);
        return "boards/boardList";
    }
}
