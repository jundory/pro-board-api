package com.example.board_api.controller;

import com.example.board_api.dto.BoardDto;
import com.example.board_api.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class boardDataController {

    //어노테이션 뭔지 알아보기
//    @Autowired
//    private BoardServiceImpl BoardServiceImpl;
    @Autowired
    BoardService boardService;


    @GetMapping("/board")
    @CrossOrigin
    public ResponseEntity<BoardDto> createBoard() {

//        mvc patten = "controller" -> dto -> service -> dao(repository) or mapper(mybatis) -> db
        //Mapper를 사용하면 일일이 DAO를 만들지 않고 인터페이스만을 이용해 더 편하게 개발 가능
//        여기서 dto를 통한 서비스를 호출해야 함. -> BoardDto는 responseDTO라고 생각하면 됨.
//        List<BoardDto> list = BoardServiceImpl.selectBoardList();
        /**
         * 게시판 조회
         */
        List<BoardDto> list = boardService.selectBoardList();
        System.out.println(list);
        return ResponseEntity.ok((BoardDto) list);
    }
}
