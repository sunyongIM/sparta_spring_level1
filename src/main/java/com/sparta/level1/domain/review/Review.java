package com.sparta.level1.domain.review;

import com.sparta.level1.domain.Timestamped;
import com.sparta.level1.domain.board.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Review extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long boardID;

    @ManyToOne()
    @JoinColumn(name = "Board_id")
    private Board boardFK;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String writer;

    public Review(Long boardID, String content, String writer){
        this.boardID = boardID;
        this.content = content;
        this.writer = writer;
    }

    public Review(ReviewDTO reviewDTO){
        this.boardID = reviewDTO.getBoardID();
        this.content = reviewDTO.getContent();
        this.writer = reviewDTO.getWriter();
    }

    public void update(ReviewDTO reviewDTO){
        this.content = reviewDTO.getContent();
        this.writer = reviewDTO.getWriter();
    }
}
