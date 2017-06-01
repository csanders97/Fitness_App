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

import com.example.csanders.getfit.Models.Meals;
import com.example.csanders.getfit.Models.Workouts;
import com.example.csanders.getfit.R;
import com.example.csanders.getfit.Tables.DBHandler;

import java.util.List;

/**
 * Created by Sophie on 5/15/2017.
 */

public class Library extends Activity  {
    private Button create;
    DBHandler db = new DBHandler(this);
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
//                final int mealId = meals.getMealId();
//                final String mealName = meals.getMealName();
//                final int mealCalories = meals.getMealCalories();
//                final int mealServings = meals.getServings();
//                final String ingredient = meals.getMeals_IngredientName();
//                final String publication = meals.getPublications();
//                final String typeMeal = meals.getMealType();
//                final String recommendations = meals.getRecommendations();
//                final String diet = meals.getDietaryRestrictions();
                dlt.setTextColor(Color.argb(255, 255, 255, 255));
                dlt.setBackgroundColor(Color.argb(1, 76, 175, 80));
//                dlt.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        deleteMeal(mealId, mealName, mealCalories, mealServings, ingredient, publication, typeMeal, recommendations, diet);
//                    }
//                });

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
                dlt.setBackgroundColor(Color.argb(1, 76, 175, 80));
                dlt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        deleteWorkout();
                    }
                });
                row.addView(name);
                row.addView(type);
                row.addView(dlt);
                tl.addView(row);
            }
        }
    }

    public void deleteMeal(int id, String name, int calorie, int serving, String ingredient, String publication, String type, String recommend, String diet) {
        db.deleteMeals(id, name, calorie, serving, ingredient, publication, type, recommend, diet);
    }

    public void deleteWorkout() {
        //db.deleteWorkouts();
    }

    public void CreateOnClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("ID", String.valueOf(ID));
        Intent create = new Intent(this, Create.class);
        create.putExtras(bundle);
        startActivity(create);
    }
}