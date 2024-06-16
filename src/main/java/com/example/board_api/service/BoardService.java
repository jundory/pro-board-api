package com.example.board_api.service;

import com.example.board_api.dto.BoardDto;

import java.util.List;

public interface BoardService {
    List<BoardDto> selectBoardList();
//    List<BoardDto> selectBoardList(String userIdx);
}
