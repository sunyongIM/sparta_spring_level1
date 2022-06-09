package com.sparta.level1.domain.board;

import com.sparta.level1.domain.Timestamped;
import com.sparta.level1.domain.review.Review;
import com.sparta.level1.domain.review.ReviewDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter             // getter 자동 생성
@NoArgsConstructor  // 기본생성자를 대신 생성해준다
@Table(name = "BoardTBL")
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

    @OneToMany(mappedBy = "boardFK")
    private List<Review> reviews = new ArrayList<>();

    public Board(BoardDTO boardDTO){
        this.title = boardDTO.getTitle();
        this.content = boardDTO.getContent();
        this.writer = boardDTO.getWriter();
    }

    // Review 클래스가 아니고 ReviewDTO 클래스를 이용해야 하나?
    // 이용해서 구현할 수 있나...?
    public void add(Review review){
        review.setBoardFK(this);
        this.reviews.add(review);
    }

    public void update(BoardDTO boardDTO){
        this.title = boardDTO.getTitle();
        this.content = boardDTO.getContent();
        this.writer = boardDTO.getWriter();
    }

}

