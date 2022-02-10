package com.example.test_project.controller;

import com.example.test_project.dto.BoardDTO;
import com.example.test_project.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// 1.1. 컨트롤러 클래스로 빈을 등록하기 위한 어노테이션을 작성하시오.
@Controller
@RequiredArgsConstructor
public class BoardController {

    // 1.2. 생성자 주입 방식을 사용하여 BoardService를 주입 받기 위한 문장을 완성하시오. (필드 이름은 bs로 한다.)
    private final BoardService bs;

    // 글쓰기 화면 요청 메서드
    @GetMapping("/board/save")
    public String saveForm() {
        return "board/save";
    }

    // 2.1. 글쓰기 메서드
    @PostMapping("/board/save")
    public String save(@ModelAttribute BoardDTO boardDTO) {
        bs.save(boardDTO);
        return "redirect:/board";
    }

    // 글목록 요청 메서드
    @GetMapping("/board")
    public String findAll(Model model) {
        List<BoardDTO> boardList = bs.findAll();
        model.addAttribute("boardList", boardList);
        return "board/findAll";
    }

    // 2.2. 글조회 메서드
    @GetMapping("/board/{boardId}")
    public String findById(@PathVariable Long boardId, Model model) {
        BoardDTO board = bs.findById(boardId);
        model.addAttribute("board", board);
        return "board/findById";
    }


}
