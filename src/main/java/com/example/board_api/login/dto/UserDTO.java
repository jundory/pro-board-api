package com.example.board_api.login.dto;

import lombok.Data;

@Data
public class UserDTO {
    private int userId;
    private String userName;
    private String loginId;
    private String password;
    private String email;
    private String createdAt;
}
