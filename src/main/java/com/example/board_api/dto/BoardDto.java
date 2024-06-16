package com.example.board_api.dto;

import lombok.Data;

@Data
public class BoardDto {
    private int boardIdx;

    private String Title;

    private String content;
}
