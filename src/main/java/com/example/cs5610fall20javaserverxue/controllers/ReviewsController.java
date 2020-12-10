package com.example.cs5610fall20javaserverxue.controllers;

import com.example.cs5610fall20javaserverxue.models.Review;
import com.example.cs5610fall20javaserverxue.services.reviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController   //add behavior accessible on the web
@CrossOrigin(origins = "*")
public class ReviewsController {

    @Autowired
    reviewService service;

    @GetMapping("/api/reviews/{reviewId}")
    public Review findReviewById(
            @PathVariable("reviewId") String reviewId) {
        return service.findReviewById(Integer.valueOf(reviewId));
    }

    @GetMapping("/api/reviews")
    public List<Review> findAllReviews() {
        return service.findAllReviews();
    }

    @GetMapping("/api/reviews/{restaurantId}/{userName}")
    public List<Review> findReviewsByRestaurantAndUser(@PathVariable("userName")String userName,
                                                       @PathVariable("restaurantId") String restaurantId) {
        return service.findReviewsByRestaurantAndUser(userName,restaurantId);
    }

    @PostMapping("/api/reviews/{restaurantId}/{userName}")
    public Review createReview(@PathVariable("userName")String userName,
                               @PathVariable("restaurantId") String restaurantId,
                               @RequestBody Review newReview) {
        return service.createReview(userName, restaurantId, newReview);
    }

    @PutMapping("/api/reviews/{restaurantId}/{userName}")
    public List<Review> updateReviewsForRestaurantAndUser(
            @PathVariable("restaurantId") String resId,
            @PathVariable("userName") String userName,
            @RequestBody List<Review> newReviews) {
        return service.updateReviews(userName,resId,newReviews);
    }

    @PutMapping("/api/reviews/{reviewId}")
    public Review updateReview(
            @PathVariable("reviewId") String reviewId,
            @RequestBody Review newReview){
        return service.updateReview(Integer.valueOf(reviewId),newReview);
    }

    @DeleteMapping("/api/reviews/{reviewId}")
    public void deleteReview(
            @PathVariable("reviewId") int reviewId) {
        service.deleteReview(reviewId);
    }

    @GetMapping("/api/reviews/restaurants/{restaurantId}")
    public List<Review> findReviewsByRestaurant(@PathVariable("restaurantId") String restaurantId) {
        return service.findReviewsByRestaurant (restaurantId);
    }


}

