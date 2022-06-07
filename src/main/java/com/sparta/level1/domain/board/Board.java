package com.sparta.level1.domain.board;

import com.sparta.level1.domain.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter             // getter 자동 생성
@NoArgsConstructor  // 기본생성자를 대신 생성해준다
@Entity             // 테이블임을 나타낸다 - 테이블이 바로 생성된다

public class Board extends Timestamped {

    @Id // ID값, Primary Key로 사용하겠다는 뜻
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String writer;

    public Board(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public Board(BoardDTO boardDTO){
        this.title = boardDTO.getTitle();
        this.content = boardDTO.getContent();
        this.writer = boardDTO.getWriter();
    }

    public void update(BoardDTO boardDTO){
        this.title = boardDTO.getTitle();
        this.content = boardDTO.getContent();
        this.writer = boardDTO.getWriter();
    }

}

