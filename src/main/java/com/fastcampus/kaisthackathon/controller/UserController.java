package com.fastcampus.kaisthackathon.controller;

import com.fastcampus.kaisthackathon.dto.LoginRequestDTO;
import com.fastcampus.kaisthackathon.dto.LoginResponseDTO;
import com.fastcampus.kaisthackathon.dto.SignupRequestDTO;
import com.fastcampus.kaisthackathon.dto.SignupResponseDTO;
import com.fastcampus.kaisthackathon.entity.UserEntity;
import com.fastcampus.kaisthackathon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDTO> signup(@RequestBody SignupRequestDTO request) {
        try {
            UserEntity savedUser = userService.signup(request);
            return ResponseEntity.ok(new SignupResponseDTO(true)); // 회원가입 성공
        } catch (Exception e) {
            return ResponseEntity.status(400).body(new SignupResponseDTO(false)); // 회원가입 실패
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request){
        UserEntity loginUser = userService.login(request);

        if(loginUser == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        LoginResponseDTO response = new LoginResponseDTO(true);

        return ResponseEntity.ok(response);
    }
}
