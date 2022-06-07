package com.sparta.level1.domain.review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByBoardIDOrderByModifiedAtDesc(Long boardID);
}
