package com.example.board_api.dto;

import lombok.Data;

@Data
public class ResponseDto {

    private Boolean state;
    private Object boardList;
    private String message;

}
