package com.sparta.level1.domain.board;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@RequiredArgsConstructor
public class BoardDTO {
    private final String title;
    private final String content;
    private final String writer;
}
