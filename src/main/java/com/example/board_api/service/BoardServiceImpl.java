package com.example.board_api.service;

import com.example.board_api.dto.BoardDto;
import com.example.board_api.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//service 해당 클래스가 서비스 클래스라는 것을 알려줌.
@Service
//public class BoardServiceImpl implements BoardService {
public class BoardServiceImpl implements BoardService {

    @Autowired // 의존성 주입 어노테이션?
    BoardMapper boardMapper;
    @Override
    public List<BoardDto> selectBoardList(){
        try {
            return boardMapper.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
