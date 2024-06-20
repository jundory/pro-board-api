package com.example.board_api.dto;

import lombok.Data;

@Data
public class BoardDto {
    // response 안에 담기는 data의 dto
    private int id;

    private String title;

    private String content;
}
