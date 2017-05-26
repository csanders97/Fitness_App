package com.example.csanders.getfit.Views;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;
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
    private ListView nameList;
    private SearchView ingredient;

    Meals meals = new Meals();
    public final static int quota = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
//        db.addMeals(new Meals(1, "Burrito", 500, 3, "publication", "NAN", "recommendations", "No Restrictions"));
//        db.addMeals(new Meals(2, "Steak Dinner", 1001, 5, "publication", "NAN", "recommendations", "No Restrictions"));
//        db.addMeals(new Meals(3, "CheeseBurger", 800, 3, "publication", "NAN", "recommendations", "No Restrictions"));
        Log.i("Test: ", "Hello");
        quotaMealSearch();
    }

    public void quotaMealSearch()
    {
        List<Meals> meal = db.getAllMeals();
        for(Meals m : meal){
            if(meals.getMealCalories() <= quota){
                if(m.getMealName() == null){
                    Log.i("Null", "Value");
                }else{
                    name = (TextView) findViewById(R.id.mealName);
                    name.setText(String.valueOf(m.getMealName()), TextView.BufferType.EDITABLE);
                    Log.i("Test3: ", m.getMealName().toString());
                }
            }
        }
    }

    public void searchMealByIngredients()
    {
        //still needs work
    }
}
