package com.sparta.level1.domain.review;

import com.sparta.level1.domain.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByBoardFKOrderByModifiedAtDesc(Board boardInstance);

}
