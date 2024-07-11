package com.example.board_api.login.controller;

import com.example.board_api.login.dto.UserDTO;
import com.example.board_api.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:9000")
@RestController
public class LoginController {

    private final LoginService loginService;

    /**
     * 로그인
     */
//    public ResponseEntity<?> login(){
//        return
//    }

    /**
     * 회원가입
     */
    @PostMapping("/signUp")
    public ResponseEntity<?>  signUp(@RequestBody UserDTO userDTO){
        return loginService.signUp(userDTO);
    }
}
