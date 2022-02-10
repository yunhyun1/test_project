package com.example.test_project.service;

import com.example.test_project.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    Long save(BoardDTO boardDTO);

    List<BoardDTO> findAll();

    BoardDTO findById(Long boardId);
}
