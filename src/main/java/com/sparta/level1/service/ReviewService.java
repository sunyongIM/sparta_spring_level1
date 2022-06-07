package com.sparta.level1.service;

import com.sparta.level1.domain.review.Review;
import com.sparta.level1.domain.review.ReviewDTO;
import com.sparta.level1.domain.review.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<Review> getReviews(Long boardID){
        return reviewRepository.findAllByBoardIDOrderByModifiedAtDesc(boardID);
    }

    public void writeReview(Review review){
        reviewRepository.save(review);
    }

    @Transactional
    public Long update(Long id, ReviewDTO reviewDTO){
        Review review = reviewRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다")
        );
        review.update(reviewDTO);
        return review.getId();
    }

    public void delete(Long id){
        reviewRepository.deleteById(id);
    }

}