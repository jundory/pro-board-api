package com.example.board_api.controller;

import com.example.board_api.dto.BoardDTO;
import com.example.board_api.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:9000")
@RestController
public class BoardController {

    @Autowired
    BoardService boardService;

    /**
     * 게시판 전체 조회
     */
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        return boardService.findAll();
    }

    /**
     * 게시판 상세 조회
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detailInfo(@PathVariable String id) {
        return boardService.detailInfo(id);
    }

    /**
     * 게시판 글 쓰기
     */
    @PostMapping("/save")
    public ResponseEntity<?> createBoard(@RequestBody BoardDTO post) {
        return boardService.createBoard(post);
    }
}
