package com.example.cs5610fall20javaserverxue.services;

import com.example.cs5610fall20javaserverxue.models.Review;
import com.example.cs5610fall20javaserverxue.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class reviewService {

    @Autowired
    ReviewRepository reviewRepository;

    public List<Review> findAllReviews() {

        return (List<Review>) reviewRepository.findAll();
    }


    public Review findReviewById(int reviewId) {
        return reviewRepository.findById(reviewId).get();
    }

    public List<Review> findReviewsByRestaurantAndUser(String userName, String resId) {

        return reviewRepository.findReviewsByRestaurantAndUser(resId, userName);
    }

    public Review createReview(String userName, String resId, Review newReview) {
        newReview.setRestaurantId(resId);
        newReview.setUserName(userName);
        return reviewRepository.save(newReview);
    }

    public Review updateReview(int reviewId, Review newReview) {
        Review r = reviewRepository.findById(reviewId).get();
        r.setText(newReview.getText());
        return reviewRepository.save(r);
    }

    public List<Review> updateReviews(String userName, String resId, List<Review> newReviews) {
        List<Review> reviewsForRestaurantAndUser = reviewRepository.findReviewsByRestaurantAndUser(resId, userName);
        for(Review r: reviewsForRestaurantAndUser) {
            reviewRepository.delete(r);
        }

        for(Review newReview: newReviews) {
            reviewRepository.save(newReview);
        }
        return reviewRepository.findReviewsByRestaurantAndUser(resId, userName);
    }

    public void deleteReview(int reviewId) {
        reviewRepository.deleteById(reviewId);
    }


    public List<Review> findReviewsByRestaurant(String resId) {
        return reviewRepository.findReviewsByRestaurant(resId);
    }

}

