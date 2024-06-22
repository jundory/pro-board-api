package com.example.board_api.mapper;

import com.example.board_api.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDto> findAll();
    List<BoardDto> detailInfo(int id);
    int lastId();
    int save(@Param("id") int id, @Param("title") String title, @Param("content") String content);

//    List<BoardDto> selectBoardList(String userId);

//@param ?? @param ??? 이런식으로 타입 지정도 했었음

//    ex)
//    List<BoardDto> selectBoardList(string param) throws Exception;
//    String test(num test);
}
