package com.example.prjjsp2.controller;

import com.example.prjjsp2.dto.Board;
import com.example.prjjsp2.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

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
    public String newBoard(Board board, RedirectAttributes rttr, Map map) {
        service.add(board);

        rttr.addFlashAttribute("message", Map.of("message", "success",
                "text", "게시물이 생성되었습니다."));
        rttr.addAttribute("id", board.getId());

        return "redirect:/board/list";
    }

    // /board/list
    // /board/list?page=1
    @GetMapping("list")
    public void listBoard(@RequestParam(name = "page", defaultValue = "1") Integer page,
                          Model model) {
        // 한 페이지에 10개의 게시물
        List<Board> list = service.list(page);
        model.addAttribute("boardList", list);

    }

    @GetMapping("view")
    public void viewBoard(Integer id, Model model) {
        Board board = service.get(id);
        model.addAttribute("board", board);
    }

    @PostMapping("delete")
    public String deleteBoard(Integer id, RedirectAttributes rttr) {
        service.delete(id);

        rttr.addFlashAttribute("message", Map.of("type", "warning",
                "text", id + "번 개시물이 삭제되었습니다."));

        return "redirect:/board/list";
    }

    @GetMapping("edit")
    public void editBoard(Integer id, Model model, RedirectAttributes rttr) {
        Board board = service.get(id);
        model.addAttribute("board1", board);

        rttr.addFlashAttribute("message",
                Map.of("type", "success",
                        "text", board.getId() + "번 게시물이 수정되었습니다."));
    }

    @PostMapping("edit")
    public String editBoard(Board board, RedirectAttributes rttr) {
        service.update(board);
        rttr.addAttribute("id", board.getId());
        return "redirect:/board/view";
    }

}
