package com.example.board_api.dto;

import lombok.Data;

@Data
public class BoardDto {
    private int id;

    private String title;

    private String content;
}
