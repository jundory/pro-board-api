package com.example.board_api.dao;

import com.example.board_api.dto.BoardDto;
import com.example.board_api.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDaoImpl implements BoardDao{
    @Autowired
    BoardMapper boardMapper;
    @Override
    public List<BoardDto> findAll() {
        return boardMapper.findAll();
    }
}
