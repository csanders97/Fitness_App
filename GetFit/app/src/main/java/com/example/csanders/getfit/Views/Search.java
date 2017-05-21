package com.example.csanders.getfit.Views;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.csanders.getfit.Models.Ingredients;
import com.example.csanders.getfit.Models.Users;
import com.example.csanders.getfit.R;
import com.example.csanders.getfit.Tables.DBHandler;

import java.util.List;

/**
 * Created by Sophie on 5/15/2017.
 */

public class Search extends Activity {
    DBHandler db = new DBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        List<Ingredients> ing = db.getAllIngredients();

        db.addIngredients(new Ingredients(1, "Banana", 89, "Fruit"));
        db.addIngredients(new Ingredients(2, "Apple", 52, "Fruit"));
        db.addIngredients(new Ingredients(3, "Strawberry", 33, "Fruit"));
        db.addIngredients(new Ingredients(4, "Orange", 47, "Fruit"));
        db.addIngredients(new Ingredients(5, "Mango", 60, "Fruit"));

        db.addIngredients(new Ingredients(1, "Lettuce", 15, "Vegetable"));
        db.addIngredients(new Ingredients(1, "Green Pepper", 20, "Vegetable"));
        db.addIngredients(new Ingredients(1, "Onion", 40, "Vegetable"));
        db.addIngredients(new Ingredients(1, "Carrot", 41, "Vegetable"));
        db.addIngredients(new Ingredients(1, "Rutabaga", 38, "Vegetable"));



        for(Ingredients ingredients : ing){
            Log.i("Categories: ", ingredients.getCategory());
            Log.i("Name: ", ingredients.getIngredientName());
            Log.i("Calories: ", Integer.toString(ingredients.getCalories()));
            Log.i("ID: ", Integer.toString(ingredients.getIngredientId()));
            Log.i("User ID: ", Integer.toString(ingredients.getIngredient_userid()));
        }
    }
}

