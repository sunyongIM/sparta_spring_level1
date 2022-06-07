package com.sparta.level1.domain.review;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ReviewDTO {
    private final Long boardID;
    private final String content;
    private final String writer;
}
