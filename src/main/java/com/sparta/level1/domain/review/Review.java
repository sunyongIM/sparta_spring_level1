package com.sparta.level1.domain.review;

import com.sparta.level1.domain.Timestamped;
import com.sparta.level1.domain.board.Board;
import com.sparta.level1.domain.board.BoardDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Table(name = "ReviewTBL")
@Entity
public class Review extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Board_ID")
    private Board boardFK;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String writer;

    /*public Review(Long boardID, String content, String writer){
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
    }*/

    ////////// ManyToOne구현

    public void setBoardFK(BoardDTO boardDTO){
        Board board = new Board(boardDTO);
        this.boardFK = board;
    }
    public void setBoardFK(Board board){
        this.boardFK = board;
    }

    public Review(ReviewDTO reviewDTO){
        this.boardFK = reviewDTO.getBoard();
        this.content = reviewDTO.getContent();
        this.writer = reviewDTO.getWriter();
    }

    public void update(ReviewDTO reviewDTO){
        this.boardFK = reviewDTO.getBoard();
        this.content = reviewDTO.getContent();
        this.writer = reviewDTO.getWriter();
    }

}
