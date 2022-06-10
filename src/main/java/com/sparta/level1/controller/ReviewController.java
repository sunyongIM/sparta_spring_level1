package com.sparta.level1.controller;

import com.sparta.level1.domain.board.Board;
import com.sparta.level1.domain.review.Review;
import com.sparta.level1.domain.review.ReviewDTO;
//import com.sparta.level1.domain.review.ReviewRepository;
import com.sparta.level1.service.ReviewService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

/// final 필드가 있으면 항상 초기화를 위한 Arg가 필요한 것이므로 @RequiredArgsConstructor 사용
@RequiredArgsConstructor
@RestController
@Builder
public class ReviewController {

    /// 의존성 주입
    private final ReviewService reviewService;

    // 6. 댓글 목록(시간순) 조회
    @GetMapping("/api/reviews/{boardID}")
    public List<Review> getReviews(@PathVariable Long boardID){
        return reviewService.getReviews(boardID);
    }

    // 7. 댓글 작성
    @Transactional
    @PostMapping("/api/reviews")
    public String createReview(@RequestBody ReviewDTO reviewDTO){
        if(reviewDTO.getContent().equals("")){
            return "댓글 내용을 입력해주세요";
        }

        Board board = reviewService.findBoardId(reviewDTO.getBoard_id());
        Review review = new Review(reviewDTO);
        /// 연관관계의  표현과 다르게 review에 board객체를 추가해주는 결과
        board.add(review);
        reviewService.writeReview(review);
        return "댓글 작성 성공";
    }

    // 8. 댓글 수정
    @PutMapping("/api/reviews/{reviewID}")
    public String updateReview(@PathVariable Long reviewID, @RequestBody ReviewDTO reviewDTO){
        if(reviewDTO.getContent().equals("")){
            return "댓글 내용을 입력해주세요";
        }
        reviewService.update(reviewID, reviewDTO);
        return "댓글 수정 성공";
    }

    // 9. 댓글 삭제
    @DeleteMapping("/api/reviews/{reviewID}")
    public String deleteReview(@PathVariable Long reviewID){
        reviewService.delete(reviewID);
        return String.format("댓글 %s 삭제 완료", reviewID);
    }

}
