package com.example.board_api.service;

import com.example.board_api.dao.BoardDao;
import com.example.board_api.dto.BoardDto;
import com.example.board_api.dto.ResponseDto;
import com.example.board_api.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//service 해당 클래스가 서비스 클래스라는 것을 알려줌.
@Service
public class BoardServiceImpl implements BoardService {
    private ResponseDto responseDto;

    @Autowired
    BoardDao bDao;
//    @Autowired // 의존성 주입 어노테이션?
//    BoardMapper boardMapper;

    @Override
    public ResponseDto findAll() {
        responseDto = new ResponseDto();
        List<BoardDto> responseList = bDao.findAll();
        if(responseList != null) {
            responseDto.setState(true);
            responseDto.setBoardList(responseList);
        } else {
            responseDto.setState(false);
        }
        return responseDto;
    }

//    @Override
//    public List<BoardDto> selectBoardList(){
//        try {
//            return boardMapper.findAll();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
}
