package com.example.prjjsp2.controller;

import com.example.prjjsp2.dto.Member;
import com.example.prjjsp2.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;


@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService service;

    @GetMapping("signup")
    public void select() {

    }

    @PostMapping("signup")
    public String save(Member member, RedirectAttributes rttr) {

        service.addMember(member);

        rttr.addFlashAttribute("message", Map.of("type", "success",
                "text", "회원가입되었습니다."));

        return "redirect:/board/list";
    }

    @GetMapping("list")
    public void list(Model model) {
        model.addAttribute("memberList", service.list());
    }

    @GetMapping("view")
    public void info(String id, Model model) {
        Member member = service.info(id);
        model.addAttribute("member", member);
    }

    @PostMapping("delete")
    public String delete(String id, String password, RedirectAttributes rttr) {

        if (service.remove(id, password)) {
            rttr.addFlashAttribute("message", Map.of("type", "dark",
                    "text", "회원 탈퇴하였습니다."));

            return "redirect:/member/signup";
        } else {
            // 탈퇴 실패
            rttr.addFlashAttribute("message", Map.of("type", "danger",
                    "text", "패스워드가 일치하지 않습니다."));
            rttr.addAttribute("id", id);

            return "redirect:/member/view";
        }
    }
}
