package com.example.test_project.dto;

import com.example.test_project.entity.BoardEntity;
import lombok.Data;

@Data
public class BoardDTO {
    private Long boardId;
    private String boardTitle;
    private String boardWriter;
    private String boardContents;
    private String boardDate;
    private int boardHits;
    public static BoardDTO toBoardDTO(BoardEntity boardEntity) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBoardId(boardEntity.getId());
        boardDTO.setBoardTitle(boardEntity.getBoardTitle());
        boardDTO.setBoardWriter(boardEntity.getBoardWriter());
        boardDTO.setBoardContents(boardEntity.getBoardContents());
        return boardDTO;

    }
}
