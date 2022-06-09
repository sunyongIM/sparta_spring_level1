package com.sparta.level1.domain.review;

import com.sparta.level1.domain.board.Board;
import com.sparta.level1.domain.board.BoardRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class ReviewDTO {

    private final BoardRepository boardRepository;

    //    private final Long id;
    private Long board_id;
    private String content;
    private String writer;

    public Board getBoard() {
        System.out.println(board_id);
        System.out.println("테스트");
        Optional<Board> ob = boardRepository.findById(board_id);
        Board board = boardRepository.findById(board_id).orElseThrow(
                () -> new IllegalArgumentException("안됨")
        );
        return board;
    }
}
