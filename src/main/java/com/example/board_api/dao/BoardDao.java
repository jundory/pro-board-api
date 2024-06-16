package com.example.board_api.dao;

import com.example.board_api.dto.BoardDto;

import java.util.List;

public interface BoardDao {
    public List<BoardDto> findAll();
}
