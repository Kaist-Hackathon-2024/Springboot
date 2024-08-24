package com.fastcampus.kaisthackathon.controller;

import com.fastcampus.kaisthackathon.dto.IdolDetailRequestDTO;
import com.fastcampus.kaisthackathon.dto.IdolDetailResponseDTO;
import com.fastcampus.kaisthackathon.entity.IdolDetailEntity;
import com.fastcampus.kaisthackathon.service.IdolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class IdolDetailController {

    private final IdolService idolService;

    @GetMapping("/idol/viewdetail")
    public ResponseEntity<IdolDetailResponseDTO> idolViewDetail(@RequestBody IdolDetailRequestDTO request){

        IdolDetailEntity idolDetailEntity = idolService.findIdolDetail(request);

        IdolDetailResponseDTO response = new IdolDetailResponseDTO(idolDetailEntity);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/ranking/fannumber")
    public ResponseEntity<List<IdolDetailResponseDTO>> findAllIdol(){
        List<IdolDetailResponseDTO> idols = idolService.findAll();
        return ResponseEntity.ok(idols);
    }

    @PutMapping("/{id}/vote/countup")
    public ResponseEntity<Void> updateIdolDetail(@PathVariable("id") Long userId, @RequestBody IdolDetailRequestDTO request) {
        idolService.countUpVote(userId, request.getIdolName());
        return ResponseEntity.ok().build(); // 성공 시 200 OK 상태 반환
    }
}