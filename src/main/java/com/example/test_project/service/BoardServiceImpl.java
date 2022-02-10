package com.example.test_project.service;

import com.example.test_project.dto.BoardDTO;
import com.example.test_project.entity.BoardEntity;
import com.example.test_project.repostiory.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
// 1.1. BoardServiceImpl 클래스는 BoardService 인터페이스의 구현클래스로 선언하시오.
public class BoardServiceImpl implements BoardService {

    private final BoardRepository br;

    // 2.1. 글쓰기 메서드를 구현하시오.
    @Override
    public Long save(BoardDTO boardDTO) {
        return br.save(BoardEntity.toBoardEntity(boardDTO)).getId();
    }

    // 2.2. 글목록 조회 메서드를 구현하시오.
    @Override
    public List<BoardDTO> findAll() {
        List<BoardEntity> boardEntityList = br.findAll();
        List<BoardDTO> boardList = new ArrayList<>();
        for (BoardEntity b : boardEntityList) {
            BoardDTO boardDTO = BoardDTO.toBoardDTO(b);
            boardList.add(boardDTO);
        }
        return boardList;
    }

    // 글조회 메서드
    @Override
    public BoardDTO findById(Long boardId) {
        BoardEntity boardEntity = br.findById(boardId).get();
        BoardDTO boardDTO = BoardDTO.toBoardDTO(boardEntity);
        return boardDTO;
    }
}
