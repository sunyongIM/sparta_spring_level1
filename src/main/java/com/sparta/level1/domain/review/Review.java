package com.sparta.level1.domain.review;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sparta.level1.domain.Timestamped;
import com.sparta.level1.domain.board.Board;
import com.sparta.level1.domain.board.BoardDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Optional;

@NoArgsConstructor
@Getter
@Table(name = "ReviewTBL")
@Entity
public class Review extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "Board_ID")
    private Board boardFK;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String writer;

    public void setBoardFK(Board board){
        this.boardFK = board;
    }

    public Review(ReviewDTO reviewDTO){
        this.content = reviewDTO.getContent();
        this.writer = reviewDTO.getWriter();
    }

    public void update(ReviewDTO reviewDTO){
        this.content = reviewDTO.getContent();
        this.writer = reviewDTO.getWriter();
    }

}
