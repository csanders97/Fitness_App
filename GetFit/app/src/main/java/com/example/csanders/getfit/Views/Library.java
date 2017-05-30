package com.example.csanders.getfit.Views;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        //db.addMeals(new Meals(1, "Burrito", 500, 3, "publication", "NAN", "recommendations", "No Restrictions"));
        //db.addMeals(new Meals(2, "Steak Dinner", 1001, 5, "publication", "NAN", "recommendations", "No Restrictions"));
        //db.addMeals(new Meals(3, "CheeseBurger", 800, 3, "publication", "NAN", "recommendations", "No Restrictions"));
        TableLayout tl = (TableLayout) findViewById(R.id.tlTable01);
        create = (Button)findViewById(R.id.createItemBtn);
        List<Meals> meal = db.getAllMeals();
        for(Meals meals : meal) {
            TableRow row = new TableRow(this);
            TextView name = new TextView(this);
            TextView type = new TextView(this);
            Button dlt = new Button(this);

            row.setBackgroundColor(Color.argb(1,204,204,204));
            row.setPadding(0, 0, 1, 1);

            name.setText(meals.getMealName());
            name.setTextSize(22);
            name.setPadding(40,15,10,15);
            name.setBackgroundColor(Color.argb(255,255,255,255));
            type.setText("Meal");
            type.setTextSize(22);
            type.setPadding(40,15,10,15);
            type.setBackgroundColor(Color.argb(255,255,255,255));
            dlt.setText("Delete");
            dlt.setTextColor(Color.argb(255,255,255,255));
            dlt.setBackgroundColor(Color.argb(1,76,175,80));


            row.addView(name);
            row.addView(type);
            row.addView(dlt);
            tl.addView(row);
        }

        List<Workouts> workout = db.getAllWorkouts();
        for(Workouts workouts : workout) {
            TableRow row = new TableRow(this);
            TextView name = new TextView(this);
            TextView type = new TextView(this);
            Button dlt = new Button(this);

            row.setBackgroundColor(Color.argb(1,204,204,204));
            row.setPadding(0, 0, 1, 1);

            name.setText(workouts.getWorkoutName());
            name.setTextSize(22);
            name.setPadding(40,15,10,15);
            name.setBackgroundColor(Color.argb(255,255,255,255));
            type.setText("Workout");
            type.setTextSize(22);
            type.setPadding(40,15,10,15);
            type.setBackgroundColor(Color.argb(255,255,255,255));
            dlt.setText("Delete");
            dlt.setTextColor(Color.argb(255,255,255,255));
            dlt.setBackgroundColor(Color.argb(1,76,175,80));


            row.addView(name);
            row.addView(type);
            row.addView(dlt);
            tl.addView(row);
        }

    }

    public void CreateOnClick(View view) {
        Intent create = new Intent(this, Create.class);
        startActivity(create);
    }
}

