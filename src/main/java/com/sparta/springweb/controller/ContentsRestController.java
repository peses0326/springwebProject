package com.sparta.springweb.controller;


import com.sparta.springweb.dto.ContentsRequestDto;
import com.sparta.springweb.model.Contents;
import com.sparta.springweb.repository.ContentsRepository;
import com.sparta.springweb.service.ContentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ContentsRestController {

    private final ContentsRepository ContentsRepository;
    private final ContentsService ContentsService;


    @GetMapping("/api/contents")
    public List<Contents> getContents() {
        return ContentsRepository.findAllByOrderByCreatedAtDesc();
    }

    @GetMapping("/api/contents/{id}")
    public Contents getContents(@PathVariable Long id) {
        Contents contents =  ContentsRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException(" "));
        return contents;
    }

    @PostMapping("/api/contents")
    public Contents createContents(@RequestBody ContentsRequestDto requestDto) {
        Contents Contents = new Contents(requestDto);
        return ContentsRepository.save(Contents);
    }

    @PutMapping("/api/contents/{id}")
    public Long updateContents(@PathVariable Long id, @RequestBody ContentsRequestDto requestDto) {
        ContentsService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/contents/{id}")
    public Long deleteContents(@PathVariable Long id) {
        ContentsRepository.deleteById(id);
        return id;
    }

}