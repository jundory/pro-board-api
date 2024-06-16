package com.example.board_api.controller;

import com.example.board_api.dto.ResponseDto;
import com.example.board_api.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class boardDataController {

    @Autowired
    BoardService boardService;

    /**
     * 게시판 전체 조회
     */
    @PostMapping("/findAll")
    public ResponseDto findAll(){
        return boardService.findAll();
    }

    /**
     * 게시판
     */
}
