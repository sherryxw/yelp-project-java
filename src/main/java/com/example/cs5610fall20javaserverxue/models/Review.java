package com.example.cs5610fall20javaserverxue.models;

import javax.persistence.*;


@Entity
@Table(name="reviews")

public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String restaurantId;
    private String userName;
    private String text;

    public Review() {

    }

    public Review(int id, String restaurantId,String userName, String text) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.userName = userName;
        this.text = text;
    }

    public Review( String restaurantId,String userName, String text) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.userName = userName;
        this.text = text;
    }


    public int getId() {
        return id;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public String getUserName() {
        return userName;
    }

    public String getText() {
        return text;
    }


    public void setRestaurantId( String newResId) {
        this.restaurantId = newResId;
    }

    public void  setUserName (String newUserName) {
        this.userName = newUserName;
    }

    public void setText (String newText) { this.text = newText;}


}
