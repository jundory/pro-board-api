package com.example.board_api.board.controller;

import com.example.board_api.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
     * 글 상세 조회
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detailInfo(@PathVariable String id) {
        return boardService.detailInfo(id);
    }

    /**
     * 글 등록 및 수정
     */
    @PostMapping("/register")
    public ResponseEntity<?> registerBoard(@RequestBody Map<String, String> post) {
        return boardService.registerBoard(post);
    }

    /**
     * 글 삭제
     */
    @DeleteMapping("/remove/{boardId}")
    public ResponseEntity<?> removeBoard(@PathVariable String boardId) {
        return boardService.deleteBoard(boardId);
    }
}
