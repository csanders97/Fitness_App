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

        for(Ingredients ingredients : ing){
            Log.i("Categories: ", ingredients.getCategory());
            Log.i("Name: ", ingredients.getIngredientName());
            Log.i("Calories: ", Integer.toString(ingredients.getCalories()));
            Log.i("ID: ", Integer.toString(ingredients.getIngredientId()));
            Log.i("User ID: ", Integer.toString(ingredients.getIngredient_userid()));
        }
    }
}

