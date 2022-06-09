package com.sparta.level1.domain.review;

import com.sparta.level1.domain.board.Board;
import com.sparta.level1.domain.board.BoardRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Review_response_DTO {
    private final BoardRepository boardRepository;
//    private final Long boardID;
    private final String content;
    private final String writer;
    private final Long boardID;

    public Board getBoardInstance(){
        return boardRepository.findById(this.boardID).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 ID")
        );
    }
}
