package com.sparta.level1.domain.review;

import com.sparta.level1.domain.board.Board;
import com.sparta.level1.domain.board.BoardRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Getter
@Setter
public class ReviewDTO {
    //    private final Long id;
    private Long board_id;
    private String content;
    private String writer;
}
