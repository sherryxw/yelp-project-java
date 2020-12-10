package com.example.cs5610fall20javaserverxue.repositories;

import com.example.cs5610fall20javaserverxue.models.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Integer> {

    @Query(value = "select * from reviews where restaurant_id =:restaurantId and user_name =:userName", nativeQuery = true)
    public List<Review> findReviewsByRestaurantAndUser(String restaurantId, String userName);

    @Query(value = "select * from reviews where restaurant_id =:restaurantId", nativeQuery = true)
    public List<Review> findReviewsByRestaurant( String restaurantId);

}
