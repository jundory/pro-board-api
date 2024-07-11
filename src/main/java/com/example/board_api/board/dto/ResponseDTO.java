package com.example.board_api.board.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseDTO {
    private Boolean state;
    private Object data;    //List가 아닐 때도 있어 Generic -> Object로 수정
    private String message;

}
