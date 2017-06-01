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
    public int meals_userID;
    public String meals_IngredientName;

    public Meals() {

    }

    public Meals(String mealName, int mealCalories, int servings, String publications, String mealType, String recommendations,String dietaryRestrictions, int meal_user_id) {
        this.mealName = mealName;
        this.mealCalories = mealCalories;
        this.servings = servings;
        this.publications = publications;
        this.mealType = mealType;
        this.recommendations = recommendations;
        this.dietaryRestrictions = dietaryRestrictions;
        this.meals_userID = meal_user_id;
    }

    public Meals(int mealId, String mealName, int mealCalories, int servings, String publications, String mealType, String recommendations,String dietaryRestrictions) {
        this.mealId = mealId;
        this.mealName = mealName;
        this.mealCalories = mealCalories;
        this.servings = servings;
        this.publications = publications;
        this.mealType = mealType;
        this.recommendations = recommendations;
        this.dietaryRestrictions = dietaryRestrictions;
    }


    public Meals(String mealName, int mealCalories, int servings, String publications, String mealType, String recommendations, int meals_userID, String meals_IngredientName) {
        this.mealName = mealName;
        this.mealCalories = mealCalories;
        this.servings = servings;
        this.publications = publications;
        this.mealType = mealType;
        this.recommendations = recommendations;
        this.meals_userID = meals_userID;
        this.meals_IngredientName = meals_IngredientName;
    }

    public Meals(int mealId, String mealName, int mealCalories, int servings,String publications, String mealType, String recommendations,String dietaryRestrictions, int meals_userID, String meals_IngredientName) {
        this.mealId = mealId;
        this.mealName = mealName;
        this.mealCalories = mealCalories;
        this.servings = servings;
        this.publications = publications;
        this.mealType = mealType;
        this.recommendations = recommendations;
        this.dietaryRestrictions = dietaryRestrictions;
        this.meals_userID = meals_userID;
        this.meals_IngredientName = meals_IngredientName;
    }

    public int getMeals_userID() {
        return meals_userID;
    }

    public void setMeals_userID(int meals_userID) {
        this.meals_userID = meals_userID;
    }

    public String getMeals_IngredientName() {
        return meals_IngredientName;
    }

    public void setMeals_IngredientName(String meals_IngredientName) {
        this.meals_IngredientName = meals_IngredientName;
    }

    public int getMealId() {
        return this.mealId;
    }
    public void setMealId(int id) {
        this.mealId = id;
    }
    public String getMealName() {
        return this.mealName;
    }
    public void setMealName(String name) {
        this.mealName = name;
    }
    public int getMealCalories() {
        return this.mealCalories;
    }
    public void setMealCalories(int calories) {
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
