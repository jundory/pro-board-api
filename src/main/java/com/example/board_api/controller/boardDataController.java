package com.example.board_api.controller;

import com.example.board_api.dto.ResponseDto;
import com.example.board_api.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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
     * 게시판 상세 조회
     */
    @GetMapping("/detail/{id}")
    public ResponseDto detailInfo(@PathVariable int id) {
        return boardService.detailInfo(id);
    }

    /**
     * 게시판 글 쓰기
     */
    @PutMapping("/addPost")
    public ResponseDto addPost(@RequestBody HashMap<String, String> post) {
        System.out.println(post);
        return boardService.addPost(post);
    }
}
