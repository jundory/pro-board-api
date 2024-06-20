package com.example.board_api.dao;

import com.example.board_api.dto.BoardDto;

import java.util.List;

public interface BoardDao {
    public int getLastId();
    public List<BoardDto> findAll();
    public List<BoardDto> detailInfo(int id);
    public List<BoardDto> addPost(int id, BoardDto post);

}
