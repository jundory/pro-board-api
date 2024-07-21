package com.example.board_api.login.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Alias("userDTO")
@Data
public class UserDTO {
    private int userId;
    private String userName;
    private String loginId;
    private String password;
    private String email;
    private String createdAt;
}
