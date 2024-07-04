package com.example.board_api.service;

import com.example.board_api.dto.BoardDTO;
import org.springframework.http.ResponseEntity;

public interface BoardService {
    ResponseEntity<?> findAll();
    ResponseEntity<?> detailInfo(String boardId);
    ResponseEntity<?> createBoard(BoardDTO post);
}
