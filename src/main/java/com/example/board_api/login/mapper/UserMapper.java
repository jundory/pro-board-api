package com.example.board_api.login.mapper;

import com.example.board_api.login.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void registerUserInfo(UserDTO userInfo);

    UserDTO checkUserByEmail(String email);
}
