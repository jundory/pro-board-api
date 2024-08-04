package com.example.board_api.comment.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CommentDTO {
    int commentId;
    String content;
    int parentCommentId;
    int boardId;
    int createdBy;
    String createdAt;
}
