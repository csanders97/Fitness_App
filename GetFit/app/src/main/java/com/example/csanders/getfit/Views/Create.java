package com.example.csanders.getfit.Views;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.csanders.getfit.Models.Ingredients;
import com.example.csanders.getfit.R;
import com.example.csanders.getfit.Tables.DBHandler;

import java.util.List;

/**
 * Created by Sophie on 5/15/2017.
 */

public class Create extends Activity {
    private RadioButton meal;
    private RadioButton workout;
    private EditText Name;
    private EditText Description;
    private EditText Calories;
    private EditText Equipment;
    private Button addItem;

    DBHandler db = new DBHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        meal = (RadioButton)findViewById(R.id.mealSelection);
        workout = (RadioButton)findViewById(R.id.workoutSelection);
        Name = (EditText)findViewById(R.id.Name);
        Description = (EditText)findViewById(R.id.Description);
        Calories = (EditText)findViewById(R.id.Calories);
        Equipment = (EditText)findViewById(R.id.Equipment);
        addItem = (Button)findViewById(R.id.addItemToDB);

        List<Ingredients> ing = db.getAllIngredients();

        db.addIngredients(new Ingredients(1, "Banana", 89, "Fruit"));
        db.addIngredients(new Ingredients(2, "Apple", 52, "Fruit"));
        db.addIngredients(new Ingredients(3, "Strawberry", 33, "Fruit"));
        db.addIngredients(new Ingredients(4, "Orange", 47, "Fruit"));
        db.addIngredients(new Ingredients(5, "Mango", 60, "Fruit"));

        db.addIngredients(new Ingredients(6, "Lettuce", 15, "Vegetable"));
        db.addIngredients(new Ingredients(7, "Green Pepper", 20, "Vegetable"));
        db.addIngredients(new Ingredients(8, "Onion", 40, "Vegetable"));
        db.addIngredients(new Ingredients(9, "Carrot", 41, "Vegetable"));
        db.addIngredients(new Ingredients(10, "Rutabaga", 38, "Vegetable"));

        db.addIngredients(new Ingredients(11, "4oz Chicken Breast (No Skin, raw)", 124, "Protein"));
        db.addIngredients(new Ingredients(12, "4.1oz Chicken Thigh (No Skin, raw)", 82, "Protein"));
        db.addIngredients(new Ingredients(13, "4oz Chicken Breast (With Skin, raw)", 194, "Protein"));
        db.addIngredients(new Ingredients(14, "4oz Beef Sirloin Steak (raw)", 227, "Protein"));
        db.addIngredients(new Ingredients(15, "4oz Pork Chop (raw)", 132, "Protein"));
        db.addIngredients(new Ingredients(16, "0.3oz Medium Slice Bacon", 46, "Protein"));

        db.addIngredients(new Ingredients(17, "1.0oz Panko Breadcrumbs", 110, "Seasoning"));
        db.addIngredients(new Ingredients(18, "1.0oz Shredded Mozzarella Cheese", 80, "Dairy"));
        db.addIngredients(new Ingredients(19, "1.0oz Grated Parmesan Cheese", 122, "Dairy"));
        db.addIngredients(new Ingredients(20, "1.0oz Canned Tomato Sauce", 7, "Seasoning"));

        for(Ingredients ingredients : ing){
            Log.i("Categories: ", ingredients.getCategory());
            Log.i("Name: ", ingredients.getIngredientName());
            Log.i("Calories: ", Integer.toString(ingredients.getCalories()));
            Log.i("ID: ", Integer.toString(ingredients.getIngredientId()));
            Log.i("User ID: ", Integer.toString(ingredients.getIngredient_userid()));
        }
    }


    public void onMealRadioButtonClicked(View view) {

        Calories.setText(" ");
        Calories.setText("Calories Gained");

    }


    public void onWorkoutRadioButtonClicked(View view) {

        Calories.setText(" ");
        Calories.setText("Calories Burned");

    }
}
