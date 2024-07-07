package com.example.board_api.dto;

import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@Alias("boardDTO")
@Builder
@Data
public class BoardDTO {
    private int boardId;

    private String title;

    private String content;

    private int viewCount;

    private int createdBy;

    private String createdDate;

    //int는 안 되는 이유 (notion 참고)
    @Nullable
    private Integer modifiedBy;

    @Nullable
    private String modifiedDate;
}
