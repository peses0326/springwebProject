package com.sparta.springweb.controller;

import com.sparta.springweb.dto.ReplyRequestDto;
import com.sparta.springweb.model.Contents;
import com.sparta.springweb.model.Reply;
import com.sparta.springweb.repository.ContentsRepository;
import com.sparta.springweb.repository.ReplyRepository;
import com.sparta.springweb.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ReplyRestController {


    private final ReplyRepository ReplyRepository;
    private final ReplyService ReplyService;


    @GetMapping("/api/reply")
    public List<Reply> getReply() {
        return ReplyRepository.findAllByOrderByCreatedAtDesc();
    }

//    @GetMapping("/api/reply/{postid}")
//    public List<Reply> getReply(@PathVariable Long postid) {
//        Reply reply =  ReplyRepository.findAllById(postid);
//        return reply;
//    }

//    @GetMapping("/api/contents/{id}")
//    public Contents getContents(@PathVariable Long id) {
//        Contents contents =  ContentsRepository.findById(id).orElseThrow(
//                ()->new IllegalArgumentException(" "));
//        return contents;
//    }


    @PostMapping("/api/reply")
    public Reply createReply(@RequestBody ReplyRequestDto requestDto) {
        Reply reply = new Reply(requestDto);
        return ReplyRepository.save(reply);
    }

    @PutMapping("/api/reply/{id}")
    public Long updateReply(@PathVariable Long id, @RequestBody ReplyRequestDto requestDto) {
        ReplyService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/reply/{id}")
    public Long deleteReply(@PathVariable Long id) {
        ReplyRepository.deleteById(id);
        return id;
    }
}
