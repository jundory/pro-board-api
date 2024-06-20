package com.example.board_api.service;

import com.example.board_api.dto.BoardDto;
import com.example.board_api.dto.ResponseDto;

public interface BoardService {
    ResponseDto findAll();
    ResponseDto detailInto(int id);
    ResponseDto addPost(BoardDto post);
}
