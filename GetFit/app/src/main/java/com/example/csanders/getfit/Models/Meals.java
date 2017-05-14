package com.example.csanders.getfit.Models;

import java.util.Date;

/**
 * Created by csanders on 5/12/2017.
 */

public class Meals {
    public int mealId;
    public String mealName;
    public int mealCalories;
    public int servings;
    public String publications;
    public String mealType;
    public String recommendations;
    public String dietaryRestrictions;

    public Meals() {

    }

    public Meals(String mealName, int mealCalories, int servings,String publications, String mealType, String recommendations,String dietaryRestrictions) {
        this.mealCalories = mealCalories;
        this.servings = servings;
        this.publications = publications;
        this.mealType = mealType;
        this.recommendations = recommendations;
        this.dietaryRestrictions = dietaryRestrictions;

    }

    public Meals(int mealId, String mealName, int mealCalories, int servings,String publications, String mealType, String recommendations,String dietaryRestrictions) {
        this.mealId = mealId;
        this.mealCalories = mealCalories;
        this.servings = servings;
        this.publications = publications;
        this.mealType = mealType;
        this.recommendations = recommendations;
        this.dietaryRestrictions = dietaryRestrictions;

    }

    public int getMealId()
    {

        return this.mealId;
    }
    public void setMealId(int id)
    {

        this.mealId = id;
    }
    public String getMealName() {

        return this.mealName;
    }
    public void setMealName(String name) {

        this.mealName = name;
    }
    public int getMealCalories()
    {

        return this.mealCalories;
    }
    public void setMealCalories(int calories)
    {

        this.mealCalories = calories;
    }
    public int getServings()
    {

        return this.servings;
    }
    public void setServings(int serve)
    {

        this.servings = serve;
    }

    public String getPublications() {

        return this.publications;
    }

    public void setPublications(String publications) {

        this.publications = publications;
    }
    public String getMealType() {

        return this.mealType;
    }
    public void setMealType(String type) {

        this.mealType = type;
    }
    public String getRecommendations() {

        return this.recommendations;
    }
    public void setRecommendations(String recommend) {

        this.recommendations = recommend;
    }
    public String getDietaryRestrictions() {

        return this.dietaryRestrictions;
    }
    public void setDietaryRestrictions(String restrict) {

        this.dietaryRestrictions = restrict;
    }
}
