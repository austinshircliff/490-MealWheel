package com.example.austin.mealwheel_490;

/**
 * Created by austin on 12/7/16.
 */

public class Restaurants {
    private String restaurantName;

    public Restaurants(){}

    public Restaurants(String restaurantName)
    {
        this.restaurantName = restaurantName;
    }

    public String getRestaurant()
    {
        return restaurantName;
    }
    public void setRestaurant(String restaurantName)
    {
        this.restaurantName = restaurantName;
    }
    @Override
    public String toString() {
        return "Restaurants" +
        "name" + restaurantName;
    }
}
