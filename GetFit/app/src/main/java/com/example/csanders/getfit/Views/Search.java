package com.example.csanders.getfit.Views;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.csanders.getfit.Models.Ingredients;
import com.example.csanders.getfit.Models.Meals;
import com.example.csanders.getfit.Models.Users;
import com.example.csanders.getfit.R;
import com.example.csanders.getfit.Tables.DBHandler;

import java.util.List;

/**
 * Created by Sophie on 5/15/2017.
 */

public class Search extends Activity {
    DBHandler db = new DBHandler(this);
    private TextView name;
    private SearchView ingredient;
    Meals meals = new Meals();
    List<Meals> meal = db.getAllMeals();
    public final static int quota = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
//        db.addMeals(new Meals(1, "Burrito", 500, 3, "publication", "NAN", "recommendations", "No Restrictions"));
//        db.addMeals(new Meals(2, "Steak Dinner", 1001, 5, "publication", "NAN", "recommendations", "No Restrictions"));
//        db.addMeals(new Meals(3, "CheeseBurger", 800, 3, "publication", "NAN", "recommendations", "No Restrictions"));
        //mealSearch();
        quotaMealSearch();
    }

    public void mealSearch()
    {
        for(Meals m : meal){
            name = (TextView)findViewById(R.id.mealName);
            //int a = m.getMealId();
            name.setText(String.valueOf(m.getMealId()), TextView.BufferType.EDITABLE);
            Log.i("Meal: ", name.toString());
        }

    }

    public void quotaMealSearch()
    {
        if(meals.getMealCalories() <= quota){
            mealSearch();
        }
    }

    public void searchMealByIngredients()
    {
        //still needs work
    }
}
