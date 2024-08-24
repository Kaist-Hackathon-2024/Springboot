package com.fastcampus.kaisthackathon.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "idoldetail")
@Getter
@Setter
@NoArgsConstructor
public class IdolDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idolid")
    private Long idolId;

    private String picture;

    @Column(name = "idolname")
    private String idolName;

    @Column(name = "groupname")
    private String groupName;

    @Column(name = "totalcount")
    private Integer totalCount;

    @Builder
    public IdolDetailEntity(String picture, String idolName, String groupName, Integer totalCount){
        this.picture = picture;
        this.idolName = idolName;
        this.groupName = groupName;
        this.totalCount = totalCount;
    }
}
