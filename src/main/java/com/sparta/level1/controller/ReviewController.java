package com.sparta.level1.controller;

import com.sparta.level1.domain.review.Review;
import com.sparta.level1.domain.review.ReviewDTO;
//import com.sparta.level1.domain.review.ReviewRepository;
import com.sparta.level1.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ReviewController {
//    private final ReviewRepository reviewRepository;
    private final ReviewService reviewService;

    // 6. 댓글 목록(시간순) 조회
    @GetMapping("/api/reviews/{boardID}")
    public List<Review> getReviews(@PathVariable Long boardID){
        return reviewService.getReviews(boardID);
    }

    // 7. 댓글 작성
    @PostMapping("/api/reviews")
    public String createReview(@RequestBody ReviewDTO reviewDTO){
        if(reviewDTO.getContent().equals("")){
            return "댓글 내용을 입력해주세요";
        }
        Review review = new Review(reviewDTO);
        reviewService.writeReview(review);
        return "댓글 작성 성공";
    }

    // 8. 댓글 수정
    @PutMapping("/api/reviews/{id}")
    public String updateReview(@PathVariable Long id, @RequestBody ReviewDTO reviewDTO){
        if(reviewDTO.getContent().equals("")){
            return "댓글 내용을 입력해주세요";
        }
        reviewService.update(id,reviewDTO);
        return "댓글 수정 성공";
    }

    // 9. 댓글 삭제
    @DeleteMapping("/api/reviews/{id}")
    public String deleteReview(@PathVariable Long id){
        reviewService.delete(id);
        return String.format("댓글 %s 삭제 완료", id);
    }

}
