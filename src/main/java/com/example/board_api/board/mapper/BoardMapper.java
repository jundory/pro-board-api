package com.example.board_api.board.mapper;

import com.example.board_api.board.dto.BoardDTO;
import com.example.board_api.board.dto.BoardListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardListDTO> findAll();
    BoardDTO detailInfo(String boardId);
    int insertBoard(BoardDTO post);
    int updateBoard(BoardDTO post);
    int deleteBoard(String boardId);
//    List<BoardDTO> selectBoardList(String userId);

//@param ?? @param ??? 이런식으로 타입 지정도 했었음

//    ex)
//    List<BoardDTO> selectBoardList(string param) throws Exception;
//    String test(num test);
}
