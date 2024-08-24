package com.fastcampus.kaisthackathon.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "trash")
@Getter
@Setter
@NoArgsConstructor
public class TrashCountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trashid")
    private Long trashId;

    @Column(name = "userid")
    private Long userId;

    private Integer plastic;

    private Integer can;

    private Integer glass;

    private Integer paper;

    private Integer stiroform;

    private Integer vinyl;

    private Integer general;
}
