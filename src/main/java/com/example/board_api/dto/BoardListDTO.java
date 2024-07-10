package com.example.board_api.dto;

import jakarta.annotation.Nullable;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@Alias("boardListDTO")
@Data
public class BoardListDTO {
    private int boardId;

    private String title;

    private int viewCount;

    private String createdDate;

    @Nullable
    private String modifiedDate;

    private String userName;
}
