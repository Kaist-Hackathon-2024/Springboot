package com.fastcampus.kaisthackathon.dto;

import com.fastcampus.kaisthackathon.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SignupRequestDTO {

    private String userEmail;

    private String userName;

    private String password;

    private String favoriteIdolName;

    public UserEntity toEntity(){
        return UserEntity.builder()
                .userEmail(userEmail)
                .userName(userName)
                .password(password)
                .favoriteIdolName(favoriteIdolName)
                .build();
    }
}
