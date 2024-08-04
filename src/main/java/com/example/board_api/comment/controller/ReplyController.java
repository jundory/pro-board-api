package com.example.board_api.comment.controller;

import com.example.board_api.comment.dto.CommentDTO;
import com.example.board_api.comment.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:9000")
@RestController
public class ReplyController {
    private final ReplyService replyService;
    @GetMapping("/commentAll/{boardId}")
    public ResponseEntity<?> commentAll(@PathVariable String boardId){
        return replyService.commentAll(boardId);
    }
    /**
     * 댓글 등록 및 수정
     */
    @PostMapping("/addComment")
    public ResponseEntity<?> registerComment(@RequestBody HashMap<String, String> comment){
        return replyService.registerComment(comment);
    }
}
