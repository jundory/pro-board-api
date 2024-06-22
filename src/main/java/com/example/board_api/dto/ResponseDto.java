package com.example.board_api.dto;

import com.example.board_api.dao.BoardDao;
import lombok.Data;

import java.util.List;

@Data
public class ResponseDto {
    private Boolean state;
    private List<BoardDto> boardList;
    private String message;

}
