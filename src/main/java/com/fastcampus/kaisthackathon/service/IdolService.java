package com.fastcampus.kaisthackathon.service;

import com.fastcampus.kaisthackathon.dto.IdolDetailRequestDTO;
import com.fastcampus.kaisthackathon.dto.IdolDetailResponseDTO;
import com.fastcampus.kaisthackathon.dto.UserQuizCountRequestDTO;
import com.fastcampus.kaisthackathon.entity.IdolDetailEntity;
import com.fastcampus.kaisthackathon.entity.UserVoteCountEntity;
import com.fastcampus.kaisthackathon.repository.IdolRepository;
import com.fastcampus.kaisthackathon.repository.UserVoteCountRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class IdolService {

    private final IdolRepository idolRepository;
    private final UserVoteCountRepository userVoteCountRepository;

    public IdolDetailEntity findIdolDetail(IdolDetailRequestDTO request){

        String idolName = request.getIdolName();

        IdolDetailEntity idolDetailEntity = idolRepository.findByIdolName(idolName)
                .orElseThrow(() -> new EntityNotFoundException("Idol not found"));

        return idolDetailEntity;
    }

    public List<IdolDetailResponseDTO> findAll() {
        // 모든 아이돌 정보를 가져옴
        List<IdolDetailEntity> idols = idolRepository.findAll();

        // 전체 투표 수 계산
        int totalVotes = idols.stream().mapToInt(IdolDetailEntity::getTotalCount).sum();

        // 아이돌 리스트를 totalCount로 내림차순 정렬하고 랭킹을 부여함
        List<IdolDetailResponseDTO> idolResponseList = idols.stream()
                .sorted(Comparator.comparing(IdolDetailEntity::getTotalCount).reversed())
                .map(idol -> {
                    int rank = idols.indexOf(idol) + 1;  // rank 계산
                    double percentage = (double) idol.getTotalCount() / totalVotes * 100;
                    return new IdolDetailResponseDTO(idol, percentage, rank);
                })
                .collect(Collectors.toList());

        return idolResponseList;
    }

    public void countUpVote(Long userId, String idolName) {
        UserVoteCountEntity userVoteCountEntity = userVoteCountRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        switch (idolName.toLowerCase()) { // 대소문자 구분 없이 처리
            case "karina":
                userVoteCountEntity.setKarina(incrementCount(userVoteCountEntity.getKarina()));
                break;
            case "winter":
                userVoteCountEntity.setWinter(incrementCount(userVoteCountEntity.getWinter()));
                break;
            case "giselle":
                userVoteCountEntity.setGiselle(incrementCount(userVoteCountEntity.getGiselle()));
                break;
            case "ningning":
                userVoteCountEntity.setNingning(incrementCount(userVoteCountEntity.getNingning()));
                break;
            case "eunwoocha":
                userVoteCountEntity.setEunwoocha(incrementCount(userVoteCountEntity.getEunwoocha()));
                break;
            case "hanni":
                userVoteCountEntity.setHanni(incrementCount(userVoteCountEntity.getHanni()));
                break;
            case "haewon":
                userVoteCountEntity.setHaewon(incrementCount(userVoteCountEntity.getHaewon()));
                break;
            case "anton":
                userVoteCountEntity.setAnton(incrementCount(userVoteCountEntity.getAnton()));
                break;
            case "jiheonbaek":
                userVoteCountEntity.setJiheonbaek(incrementCount(userVoteCountEntity.getJiheonbaek()));
                break;
            case "yuqi":
                userVoteCountEntity.setYuqi(incrementCount(userVoteCountEntity.getYuqi()));
                break;
            default:
                throw new IllegalArgumentException("Invalid idol name");
        }

        userVoteCountRepository.save(userVoteCountEntity);
    }

    private Integer incrementCount(Integer currentCount) {
        return (currentCount != null ? currentCount : 0) + 1;
    }
}