package com.fastcampus.kaisthackathon.dto;

import com.fastcampus.kaisthackathon.entity.IdolDetailEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class IdolDetailResponseDTO {

    private String picture;

    private String idolName;

    private String groupName;

    private Integer totalCount;

    private Double percentage;

    private Integer rank;

    public IdolDetailResponseDTO(IdolDetailEntity entity, Double percentage, Integer rank) {
        this.picture = entity.getPicture();
        this.idolName = entity.getIdolName();
        this.groupName = entity.getGroupName();
        this.totalCount = entity.getTotalCount();
        this.percentage = percentage;
        this.rank = rank;
    }

    public IdolDetailResponseDTO(IdolDetailEntity entity) {
        this.picture = entity.getPicture();
        this.idolName = entity.getIdolName();
        this.groupName = entity.getGroupName();
        this.totalCount = entity.getTotalCount();
        this.percentage = 0.0;  // 기본값 설정
        this.rank = 0;          // 기본값 설정
    }
}
