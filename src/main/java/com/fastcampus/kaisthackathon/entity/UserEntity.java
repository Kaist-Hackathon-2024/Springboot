package com.fastcampus.kaisthackathon.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "useremail", unique = true)
    private String userEmail;

    @Column(name = "username")
    private String userName;

    private String password;

    @Column(name = "favoriteidolname")
    private String favoriteIdolName;

    @Builder
    public UserEntity(String userEmail, String userName, String password, String favoriteIdolName){
        this.userEmail = userEmail;
        this.userName = userName;
        this.password = password;
        this.favoriteIdolName = favoriteIdolName;
    }
}
