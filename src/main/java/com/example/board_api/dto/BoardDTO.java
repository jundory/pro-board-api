package com.example.board_api.dto;

import lombok.Builder;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@Alias("boardDTO")
@Builder
@Data
public class BoardDTO {
    private Integer boardId;

    private String title;

    private String content;

    private int viewCount;

    private String createdDate;

    private String modifiedDate;

    private Integer userId;
}
