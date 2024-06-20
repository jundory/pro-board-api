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
    BoardDao boardDao;

    @Override
    public ResponseDto findAll() {
        responseDto = new ResponseDto(); // response instance 생성
        List<BoardDto> responseList = boardDao.findAll(); // Mapper 호출
        if(responseList != null) {
            responseDto.setState(true);
            responseDto.setBoardList(responseList);
            responseDto.setMessage("정상 처리되었습니다.");
        } else {
            responseDto.setState(false);
            responseDto.setMessage("게시글이 존재하지 않습니다");
        }
        return responseDto;
    }

    //이건 위랑 합쳐야겠다..
    @Override
    public ResponseDto detailInto(int id) {
        responseDto = new ResponseDto();
        List<BoardDto> responseList = boardDao.detailInfo(id);
        if(responseList != null) {
            responseDto.setState(true);
            responseDto.setBoardList(responseList);
            responseDto.setMessage("정상 처리되었습니다.");
        } else {
            responseDto.setState(false);
            responseDto.setMessage("해당 글이 존재하지 않습니다.");
        }
        return responseDto;
    }

    @Override
    public ResponseDto addPost(BoardDto post) {
        responseDto = new ResponseDto();
        int lastId;
        lastId = boardDao.getLastId() + 1;
        List<BoardDto> result = boardDao.addPost(lastId, post);
        if(result != null){
            responseDto.setMessage("글 등록이 완료되었습니다.");
            responseDto.setState(true);
        }
        else {
            responseDto.setState(false);
            responseDto.setMessage("글 등록에 실패하였습니다");
        }
        return responseDto;
    }
}
