package com.example.prjjsp2.controller;

import com.example.prjjsp2.dto.Board;
import com.example.prjjsp2.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;


    // 게시물 CRUD

    // /board/new
    @GetMapping("new")
    public void newBoard() {

        // /WEB-INF/view/board/new.jsp
    }

    @PostMapping("new")
    public String newBoard(Board board) {
        service.add(board);

        return "redirect:/board/new";
    }

    @GetMapping("list")
    public void listBoard(Model model) {
        List<Board> list = service.list();
        model.addAttribute("boardList", list);
    }
}
