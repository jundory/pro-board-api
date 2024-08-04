package com.example.board_api.comment.service;

import com.example.board_api.board.dto.ResponseDTO;
import com.example.board_api.comment.dto.CommentDTO;
import com.example.board_api.comment.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

import static com.example.board_api.common.Utils.convertToInt;

@RequiredArgsConstructor
@Service
public class ReplyService {

    private final CommentMapper commentMapper;
    public ResponseEntity<?> commentAll(String boardId){
        try {
            List<CommentDTO> commentList = commentMapper.getCommentAll(boardId);
            ResponseDTO result = ResponseDTO.builder()
                    .state(true)
                    .message("댓글 조회 완료")
                    .data(commentList)
                    .build();
            if(commentList.size() == 0){
                result.setState(false);
            }
            return ResponseEntity.ok(result);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    public ResponseEntity<?> registerComment(HashMap<String, String> comment){
            CommentDTO reply = CommentDTO.builder()
                    .content(comment.get("content"))
                    .boardId(convertToInt(comment.get("boardId")))
                    .createdBy(convertToInt(comment.get("userId")))
                    .build();
            int state = commentMapper.insertComment(reply);
            ResponseDTO result = ResponseDTO.builder()
                    .message("등록이 완료되었습니다.")
                    .state(true)
                    .build();
            if(state != 1){
                result.setMessage("등록에 실패했습니다.");
                result.setState(false);
            }
            return ResponseEntity.ok(result);
    }
}
