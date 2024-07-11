package com.example.board_api.board.dao;

import com.example.board_api.board.dto.BoardDTO;
import com.example.board_api.board.dto.BoardListDTO;
import com.example.board_api.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDaoImpl implements BoardDao{
    @Autowired
    BoardMapper boardMapper;
    @Override
    public List<BoardListDTO> findAll() {
        return boardMapper.findAll();
    }
    @Override
    public BoardDTO detailInfo(String boardId) {
        return boardMapper.detailInfo(boardId);
    }
    @Override
    public int insertBoard(BoardDTO post){
        return boardMapper.insertBoard(post);
    }

    @Override
    public int updateBoard(BoardDTO post){
        return boardMapper.updateBoard(post);
    }
    @Override
    public int deleteBoard(String post) {return boardMapper.deleteBoard(post); }
}
