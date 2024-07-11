package com.example.board_api.login.service;

import com.example.board_api.login.dto.UserDTO;
import com.example.board_api.login.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final UserMapper userMapper;
    public ResponseEntity<?> signUp(UserDTO userInfo){
        try {
            UserDTO user = userMapper.checkUserByEmail(userInfo.getEmail());
            int result = userMapper.registerUser(userInfo);
            return ResponseEntity.ok(result);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
