package com.example.board_api.dao;

import com.example.board_api.dto.BoardDTO;
import com.example.board_api.dto.BoardListDTO;

import java.util.List;

public interface BoardDao {
    public List<BoardListDTO> findAll();
    public BoardDTO detailInfo(String boardId);
    public int insertBoard(BoardDTO post);
    public int updateBoard(BoardDTO post);
    public int deleteBoard(String post);
}
