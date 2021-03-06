package com.example.csanders.getfit.Views;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.csanders.getfit.Models.Meals;
import com.example.csanders.getfit.Models.Workouts;
import com.example.csanders.getfit.R;
import com.example.csanders.getfit.Tables.DBHandler;

import java.util.List;

/**
 * Created by Sophie on 5/15/2017.
 */

public class Library extends Activity  {
    Button create;
    Button home;
    DBHandler db = new DBHandler(this);
    int workoutId;
    int mealId;
    int ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        Bundle bundle = getIntent().getExtras();
        String use = bundle.getString("ID");
        ID = Integer.parseInt(use);
        TableLayout tl = (TableLayout) findViewById(R.id.tlTable01);
        create = (Button)findViewById(R.id.createItemBtn);
        home = (Button)findViewById(R.id.back);
        List<Meals> meal = db.getAllMeals();
        for(Meals meals : meal) {
            if (meals.meals_userID == ID) {
                TableRow row = new TableRow(this);
                TextView name = new TextView(this);
                TextView type = new TextView(this);
                Button dlt = new Button(this);

                row.setBackgroundColor(Color.argb(1, 204, 204, 204));
                row.setPadding(0, 0, 1, 1);

                name.setTextSize(20);
                name.setText(meals.getMealName());
                name.setTextSize(22);
                name.setPadding(40, 15, 10, 15);
                name.setBackgroundColor(Color.argb(255, 255, 255, 255));

                type.setText("Meal");
                type.setTextSize(22);
                type.setPadding(40, 15, 10, 15);
                type.setBackgroundColor(Color.argb(255, 255, 255, 255));
                dlt.setText("Delete");
                mealId = meals.getMealId();
                final String mealName = meals.getMealName();
                final int mealCalories = meals.getMealCalories();
                final int mealServings = meals.getServings();
                final String ingredient = meals.getMeals_IngredientName();
                final String publication = meals.getPublications();
                final String typeMeal = meals.getMealType();
                final String recommendations = meals.getRecommendations();
                final String diet = meals.getDietaryRestrictions();
                final String instruct = meals.getInstructions();
                dlt.setTextColor(Color.argb(255, 255, 255, 255));
                dlt.setBackgroundColor(Color.argb(1, 76, 175, 80));
                dlt.setBackgroundColor(Color.parseColor("#4CAF50"));
                dlt.setOnClickListener(checkMealButton(dlt, mealId, mealName, mealCalories, mealServings, ingredient, publication, typeMeal, recommendations, instruct, diet));

                name.setOnClickListener(sendMealItemID(mealId));

                row.addView(name);
                row.addView(type);
                row.addView(dlt);
                tl.addView(row);
            }
        }

        List<Workouts> workout = db.getAllWorkouts();
        for(Workouts workouts : workout) {

            if (workouts.getWorkout_user_id() == ID) {
                TableRow row = new TableRow(this);
                TextView name = new TextView(this);
                TextView type = new TextView(this);
                Button dlt = new Button(this);

                row.setBackgroundColor(Color.argb(1, 204, 204, 204));
                row.setPadding(0, 0, 1, 1);
                workoutId = workouts.getWorkoutId();
                final String workoutName = workouts.getWorkoutName();
                final String workoutType = workouts.getWorkoutType();
                final String workoutEquipment = workouts.getEquipment();
                final int workoutLength = workouts.getLength();
                final int workoutCalories = workouts.getCaloriesBurned();
                final String workoutPublished = workouts.getWorkoutPublished();
                final String workoutInstructions = workouts.getWorkoutInstructions();
                name.setText(workouts.getWorkoutName());
                name.setTextSize(22);
                name.setPadding(40, 15, 10, 15);
                name.setBackgroundColor(Color.argb(255, 255, 255, 255));
                type.setText("Workout");
                type.setTextSize(22);
                type.setPadding(40, 15, 10, 15);
                type.setBackgroundColor(Color.argb(255, 255, 255, 255));
                dlt.setText("Delete");

                dlt.setTextColor(Color.argb(255, 255, 255, 255));
                dlt.setBackgroundColor(Color.parseColor("#4CAF50"));
                dlt.setOnClickListener(checkWorkoutButton(dlt, workoutId, workoutName, workoutType, workoutEquipment, workoutLength, workoutCalories, workoutPublished, workoutInstructions));

                name.setOnClickListener(sendWorkoutItemID(workoutId));

                row.addView(name);
                row.addView(type);
                row.addView(dlt);
                tl.addView(row);
            }
        }
    }

    View.OnClickListener checkMealButton(final Button button, final int id, final String name, final int calorie, final int serving, final String ingredient, final String publication, final String type, final String recommend, final String instruct, final String diet) {
        return new View.OnClickListener() {
            public void onClick(View v) {
                db.deleteMeals(id, name, calorie, serving, publication, type, recommend, instruct, diet, ingredient);
                finish();
                startActivity(getIntent());
                Toast.makeText(getApplicationContext(), "Meal Deleted!", Toast.LENGTH_LONG).show();
            }
        };
    }

    View.OnClickListener checkWorkoutButton(final Button button, final int id, final String name, final String type, final String equipment, final int length, final int calorie, final String publish, final String instruct) {
        return new View.OnClickListener() {
            public void onClick(View v) {
                db.deleteWorkouts(id, name, type, equipment, length, calorie, publish, instruct);
                finish();
                startActivity(getIntent());
                Toast.makeText(getApplicationContext(), "Workout Deleted!", Toast.LENGTH_LONG).show();
            }
        };
    }

    public void CreateOnClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("ID", String.valueOf(ID));
        Intent create = new Intent(this, Create.class);
        create.putExtras(bundle);
        startActivity(create);
    }

    public void BackHome(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("stuff", String.valueOf(ID));
        Intent home = new Intent(this, Home.class);
        home.putExtras(bundle);
        startActivity(home);
    }

    View.OnClickListener sendMealItemID(final int id) {
        return new View.OnClickListener() {
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("Meal", String.valueOf(id));
                Intent item = new Intent(v.getContext(), Item.class);
                item.putExtras(bundle);
                startActivity(item);
            }
        };
    }

    View.OnClickListener sendWorkoutItemID(final int id) {
        return new View.OnClickListener() {
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("Workout", String.valueOf(id));
                Intent item = new Intent(v.getContext(), Item.class);
                item.putExtras(bundle);
                startActivity(item);
            }
        };
    }
}