package com.fastcampus.kaisthackathon.service;

import com.fastcampus.kaisthackathon.dto.LoginRequestDTO;
import com.fastcampus.kaisthackathon.dto.SignupRequestDTO;
import com.fastcampus.kaisthackathon.entity.UserEntity;
import com.fastcampus.kaisthackathon.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserEntity signup(SignupRequestDTO request){
        return userRepository.save(request.toEntity());
    }

    public UserEntity login(LoginRequestDTO request){

        UserEntity userEntity = userRepository.findByUserEmail(request.getUserEmail())
                .orElseThrow(() -> new RuntimeException("User not found with login id: " + request.getUserEmail()));

        if(!userEntity.getPassword().equals(request.getPassword())){
            throw new RuntimeException("Invalid password for login id: " + request.getUserEmail());
        }

        return userEntity;
    }
}
