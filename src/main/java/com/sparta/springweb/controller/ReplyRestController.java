package com.sparta.springweb.controller;

import com.sparta.springweb.dto.ReplyRequestDto;
import com.sparta.springweb.model.Contents;
import com.sparta.springweb.model.Reply;
import com.sparta.springweb.repository.ContentsRepository;
import com.sparta.springweb.repository.ReplyRepository;
import com.sparta.springweb.security.UserDetailsImpl;
import com.sparta.springweb.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ReplyRestController {


    private final ReplyRepository ReplyRepository;
    private final ReplyService ReplyService;


//    @GetMapping("/api/reply")
//    public List<Reply> getReply() {
//        return ReplyRepository.findAllByOrderByCreatedAtDesc();
//    }

    // 로그인한 회원이 등록한 상품들 조회
    @GetMapping("/api/reply")
    public List<Reply> getReply(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        Long userId = userDetails.getUser().getId();
        return ReplyService.getReply(userId);
    }
    // 게시글 id 로 댓글 조회
    @GetMapping("/api/reply/{postId}")
    public List<Reply> getReply(@PathVariable Long postId) {
        return ReplyService.getReply(postId);
    }

@PostMapping("/api/reply")
public Reply createReply(@RequestBody ReplyRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
    // 로그인 되어 있는 ID
    Long userId = userDetails.getUser().getId();
    Reply reply = ReplyService.createReply(requestDto, userId);
    // 응답 보내기
    return reply;
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
