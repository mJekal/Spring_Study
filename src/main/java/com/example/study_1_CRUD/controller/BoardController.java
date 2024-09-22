package com.example.study_1_CRUD.controller;

import com.example.study_1_CRUD.domain.Board;
import com.example.study_1_CRUD.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

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
        return "redirect:/boards";
    }

    @GetMapping("/boards")
    public String list(Model model) {
        List<Board> boards = boardService.findBoards();
        model.addAttribute("boards", boards);
        return "boards/boardList";
    }

    @GetMapping("/boards/{boardId}/edit")
    public String modifyBoardForm(@PathVariable("boardId") Long boardId, Model model){
        Board board = (Board) boardService.findOne(boardId);
        BoardForm form = new BoardForm();
        form.setId(board.getId());
        form.setTitle(board.getTitle());
        form.setContent(board.getContent());
        model.addAttribute("form",form);
        return "boards/modifyBoardForm";
    }

    @PostMapping("/boards/{boardId}/edit")
    public String modifyBoard(@PathVariable("boardId") Long boardId, @ModelAttribute("form") BoardForm form) {
        boardService.modifyBoard(boardId, form.getTitle(), form.getContent());
        return "redirect:/boards";
    }

    @GetMapping("/delete/{id}")
    public String deleteBoard(@PathVariable("id") Long id) {
        boardService.deleteBoard(id);
        return "redirect:/boards";
    }
}
