package com.example.board_api.service;

import com.example.board_api.dto.BoardDTO;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface BoardService {
    ResponseEntity<?> findAll();
    ResponseEntity<?> detailInfo(String boardId);
    ResponseEntity<?> registerBoard(Map<String, String> post);

    ResponseEntity<?> deleteBoard(String boardId);
}
