package com.example.board_api.comment.mapper;

import com.example.board_api.comment.dto.CommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<CommentDTO> getCommentAll(String boardId);
    int insertComment(CommentDTO reply);

}
