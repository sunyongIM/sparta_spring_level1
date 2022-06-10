package com.sparta.level1.domain.board;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonManagedReference
    @OneToMany(mappedBy = "boardFK", cascade = CascadeType.ALL)
    private final List<Review> reviews = new ArrayList<>();

    public Board(BoardDTO boardDTO){
        this.title = boardDTO.getTitle();
        this.content = boardDTO.getContent();
        this.writer = boardDTO.getWriter();
    }

    public void add(Review review){
        review.setBoardFK(this);
        /// 연관관계의 주인이 Review엔티티 이므로,
        /// Board객체의 reviews에 review를 추가하는 것이 아니라
        /// Review객체의 review에 BoardFK를 설정해주면 알아서 reviews에 기록이 된다
        /// (하지만 굳이 `this.reviews.add(review);`를 없엘 필요는 없다)
//        this.reviews.add(review);
    }

    public void update(BoardDTO boardDTO){
        this.title = boardDTO.getTitle();
        this.content = boardDTO.getContent();
        this.writer = boardDTO.getWriter();
    }

}

