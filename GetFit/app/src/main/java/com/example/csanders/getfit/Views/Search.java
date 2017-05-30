package com.example.csanders.getfit.Views;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
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

    private SearchView ingredient;

    Meals meals = new Meals();
    public final static int quota = 1000;

    List<Meals> meal;
    String[] mealArray;
    ArrayAdapter<String> test = new ArrayAdapter<String>(this, R.layout.activity_search, mealArray);
    ListView nameList = (ListView) findViewById(R.id.listOfMeals);
    //nameList.setAdapter(test);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Log.i("Test: ", "Hello");
        quotaMealSearch();
    }

    public void mealDisplay(int index){
        name = (TextView) findViewById(R.id.mealName);
        name.setText(String.valueOf(mealArray[index]), TextView.BufferType.EDITABLE);
        Log.i("Test3: ", mealArray[index]);
    }

    public void quotaMealSearch()
    {
        meal = db.getAllMeals();
        mealArray =  new String[meal.size()];
        //String item = ingredient.getQuery().toString();

        for(int i = 0; i < meal.size(); i++){
            mealArray[i] = meal.get(i).getMealName();
            if(meals.getMealCalories() <= quota){
                if(mealArray[i] == null){
                    Log.i("Null", "Value");
                }else{
                    searchMealByIngredients(i);
                }
            }
        }
    }


    public void searchMealByIngredients(int index)
    {
        String item = ingredient.getQuery().toString();

        if(item == meal.get(index).getMeals_IngredientName() || item == meal.get(index).getDietaryRestrictions() || item == meal.get(index).getRecommendations()){
            mealDisplay(index);
        }
    }

}
