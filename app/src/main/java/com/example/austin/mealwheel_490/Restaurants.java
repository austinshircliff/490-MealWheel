package com.example.austin.mealwheel_490;

/**
 * Created by austin on 12/7/16.
 */

public class Restaurants {
    private String name;

    public Restaurants(){}

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString() {
        return "Restaurants" +
                "name" + name;
    }
}