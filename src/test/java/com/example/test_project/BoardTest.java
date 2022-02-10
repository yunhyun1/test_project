package com.example.test_project;

import com.example.test_project.dto.BoardDTO;
import com.example.test_project.repostiory.BoardRepository;
import com.example.test_project.service.BoardService;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardTest {
    @Autowired
    private BoardService bs;
    @Autowired
    private BoardRepository br;

    // 글 조회 테스트만
    // 작성하고 해당 아이디로 조회하는 내용
    // 적당히 틀을 짜놓고 채우는 방식으로

    @Test
    public void findByIdTest() {
        String testTitle = "테스트제목";
        String testWriter = "테스트작성자";
        String testContents = "테스트내용";
        BoardDTO newBoard = new BoardDTO();
        newBoard.setBoardTitle(testTitle);
        newBoard.setBoardWriter(testWriter);
        newBoard.setBoardContents(testContents);

        Long saveBoardId = bs.save(newBoard);

        BoardDTO boardDTO = bs.findById(saveBoardId);
        String boardWriter = boardDTO.getBoardWriter();

        assertThat(boardWriter).isEqualTo(testWriter);
    }

}


















