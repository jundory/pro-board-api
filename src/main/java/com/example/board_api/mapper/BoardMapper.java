package com.example.board_api.mapper;

import com.example.board_api.dto.BoardDTO;
import com.example.board_api.dto.BoardListDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardListDTO> findAll();
    BoardDTO detailInfo(String boardId);
    int insertBoard(BoardDTO post);

//    List<BoardDTO> selectBoardList(String userId);

//@param ?? @param ??? 이런식으로 타입 지정도 했었음

//    ex)
//    List<BoardDTO> selectBoardList(string param) throws Exception;
//    String test(num test);
}
