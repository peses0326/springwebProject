package com.sparta.springweb.model;

import com.sparta.springweb.dto.ReplyRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Reply extends Timestamped {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private Long postid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String reply;

    public Reply(Long postid, String name, String reply) {
        this.name = name;
        this.reply = reply;
    }

    public Reply(ReplyRequestDto requestDto) {
        this.postid = requestDto.getPostid();
        this.name = requestDto.getName();
        this.reply = requestDto.getReply();
    }

    public void update(ReplyRequestDto requestDto) {
        this.postid = requestDto.getPostid();
        this.name = requestDto.getName();
        this.reply = requestDto.getReply();
    }
}
