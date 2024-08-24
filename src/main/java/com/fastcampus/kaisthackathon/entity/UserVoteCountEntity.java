package com.fastcampus.kaisthackathon.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "uservotecount")
@Getter
@Setter
@NoArgsConstructor
public class UserVoteCountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uservotecountid;

    @Column(name = "userid")
    private Long userId;

    private Integer karina;

    private Integer winter;

    private Integer giselle;

    private Integer ningning;

    private Integer eunwoocha;

    private Integer hanni;

    private Integer haewon;

    private Integer anton;

    private Integer jiheonbaek;

    private Integer yuqi;

    public void quizVoteUpdate(Integer karina, Integer winter, Integer giselle, Integer ningning, Integer eunwoocha, Integer hanni, Integer haewon, Integer anton, Integer jiheonbaek, Integer yuqi){
        this.karina = karina;
        this.winter = winter;
        this.giselle = giselle;
        this.ningning = ningning;
        this.eunwoocha = eunwoocha;
        this.hanni = hanni;
        this.haewon = haewon;
        this.anton = anton;
        this.jiheonbaek = jiheonbaek;
        this.yuqi = yuqi;
    }
}
