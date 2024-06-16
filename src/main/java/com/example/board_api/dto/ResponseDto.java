package com.example.board_api.dto;

import lombok.Data;

@Data
public class ResponseDto {
    // front에서 받을 response의 dto
    private Boolean state;
    private Object boardList;
    private String message;

}
