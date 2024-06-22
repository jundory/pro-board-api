package com.example.board_api.service;

import com.example.board_api.dto.ResponseDto;

import java.util.HashMap;

public interface BoardService {
    ResponseDto findAll();
    ResponseDto detailInfo(int id);
    ResponseDto addPost(HashMap<String, String> post);
}
