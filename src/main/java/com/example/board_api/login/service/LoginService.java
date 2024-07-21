package com.example.board_api.login.service;

import com.example.board_api.login.dto.UserDTO;
import com.example.board_api.login.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.board_api.board.dto.ResponseDTO;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserMapper userMapper;
    public ResponseEntity<?> signUp(UserDTO userInfo){
        try {
            boolean status = false;
            String message = "이미 등록된 계정이 있습니다.";

            UserDTO user = userMapper.checkUserByEmail(userInfo.getEmail());
            if(user == null) {
                userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
                userMapper.registerUserInfo(userInfo);

                status = true;
                message = "가입되었습니다.";
            }
//            Map<String, Object> result = new HashMap<>();
//            result.put("status", status);
//            result.put("message", message);
            ResponseDTO result = ResponseDTO.builder().state(status).message(message).build();
            return ResponseEntity.ok(result);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
