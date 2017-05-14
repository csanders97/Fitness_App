package com.example.csanders.getfit.Models;

/**
 * Created by Matthew Balderas on 5/13/2017.
 */

public class Ingredients {

    private int ingredientId;
    private String IngredientName;
    private int Calories;
    private String Category;


    public Ingredients() {

    }

    public Ingredients(int ingredientId, String IngredientName, int Calories, String Category) {

        this.ingredientId = ingredientId;
        this.IngredientName = IngredientName;
        this.Calories = Calories;
        this.Category = Category;


    }

    public int getIngredientId() {

        return this.ingredientId;
    }

    public void setIngredientId(int id) {

        this.ingredientId = id;
    }


    public String getIngredientName() {

        return this.IngredientName;
    }

    public void setIngredientName(String name) {

        this.IngredientName = name;
    }

    public int getCalories() {

        return this.Calories;
    }

    public void setCalories(int calories) {

        this.Calories = calories;
    }

    public String getCategory() {

        return this.Category;
    }

    public void setCategory(String category) {

        this.Category = category;
    }


}
