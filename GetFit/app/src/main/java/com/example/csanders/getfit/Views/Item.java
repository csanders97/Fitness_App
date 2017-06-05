package com.example.csanders.getfit.Views;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.csanders.getfit.Models.Meals;
import com.example.csanders.getfit.Models.Users;
import com.example.csanders.getfit.Models.Workouts;
import com.example.csanders.getfit.R;
import com.example.csanders.getfit.Tables.DBHandler;

/**
 * Created by Sophie on 6/2/2017.
 */

public class Item extends Activity {
    DBHandler db = new DBHandler(this);
    Users user = new Users();
    String item;
    TextView name;
    TextView type;
    TextView author;
    TextView ingredients;
    TextView instructions;
    TextView date;
    TextView specs;
    int ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        boolean isMeal = false;
        Bundle bundle = getIntent().getExtras();
        if (bundle.containsKey("Meal")) {
            isMeal = true;
            ID = Integer.parseInt(bundle.getString("Meal"));
            displayMealItem(ID);
        }
        else if (bundle.containsKey("Workout")) {
            isMeal = false;
            ID = Integer.parseInt(bundle.getString("Workout"));
            displayWorkoutItem(ID);
        }
    }

    public void displayMealItem(int mealId) {
        Meals meal = new Meals();
        meal = db.getMeals(mealId);
        name = (TextView) findViewById(R.id.itemNameLbl);
        name.setText(meal.getMealName());
        type = (TextView) findViewById(R.id.type);
        type.setText(meal.getMealType());
        author = (TextView) findViewById(R.id.author);
        int mealAuthor = meal.getMeals_userID();
        user = db.getUsers(mealAuthor);
        author.setText(user.getUserName());
        ingredients = (TextView) findViewById(R.id.ingredient);
        ingredients.setText(meal.getMeals_IngredientName());
        instructions = (TextView) findViewById(R.id.instructions);
        instructions.setText(meal.getDietaryRestrictions());
        date = (TextView) findViewById(R.id.date);
        date.setText(meal.getPublications());
        specs = (TextView) findViewById(R.id.SpecList);
        specs.setText("Calorie Count: " + meal.getMealCalories() + ", Servings: " + meal.getServings());
    }

    public void displayWorkoutItem(int workoutId) {
        Workouts workout = new Workouts();
        workout = db.getWorkouts(workoutId);
        name = (TextView) findViewById(R.id.itemNameLbl);
        name.setText(workout.getWorkoutName());
        type = (TextView) findViewById(R.id.type);
        type.setText(workout.getWorkoutType());
        author = (TextView) findViewById(R.id.author);
        int workoutAuthor = workout.getWorkout_user_id();
        user = db.getUsers(workoutAuthor);
        author.setText(user.getUserName());
        ingredients = (TextView) findViewById(R.id.ingredient);
        ingredients.setText(workout.getEquipment());
        instructions = (TextView) findViewById(R.id.instructions);
        instructions.setText(workout.getWorkoutInstructions());
        date = (TextView) findViewById(R.id.date);
        date.setText(workout.getWorkoutPublished());
        specs = (TextView) findViewById(R.id.SpecList);
        specs.setText("Calories Burned: " + workout.getCaloriesBurned() + ", Length: " + workout.getLength() + " minutes");
    }
}