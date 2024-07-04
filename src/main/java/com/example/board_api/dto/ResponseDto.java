package com.example.board_api.dto;

import com.example.board_api.dao.BoardDao;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ResponseDto {
    private Boolean state;
    private Object data;    //List가 아닐 때도 있어 Generic -> Object로 수정
    private String message;

}
