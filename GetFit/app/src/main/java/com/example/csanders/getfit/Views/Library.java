package com.example.csanders.getfit.Views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.csanders.getfit.Models.Meals;
import com.example.csanders.getfit.R;
import com.example.csanders.getfit.Tables.DBHandler;

import java.util.List;

/**
 * Created by Sophie on 5/15/2017.
 */

public class Library extends Activity implements View.OnClickListener {
    private Button create;
    DBHandler db = new DBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
//        db.addMeals(new Meals(1, "Burrito", 500, 3, "publication", "NAN", "recommendations", "No Restrictions"));
//        db.addMeals(new Meals(2, "Steak Dinner", 1001, 5, "publication", "NAN", "recommendations", "No Restrictions"));
//        db.addMeals(new Meals(3, "CheeseBurger", 800, 3, "publication", "NAN", "recommendations", "No Restrictions"));
        TableLayout tl = (TableLayout) findViewById(R.id.tlTable01);
        create = (Button)findViewById(R.id.createItemBtn);
        List<Meals> meal = db.getAllMeals();
        for(Meals meals : meal) {
            TableRow row = new TableRow(this);
            TextView name = new TextView(this);
            TextView type = new TextView(this);

            name.setText(meals.getMealName());
            type.setText(meals.getMealType());

            row.addView(name);
            row.addView(type);
            tl.addView(row);
        }

    }

    @Override
    public void onClick(View v) {
        Intent create = new Intent(this, Create.class);
        startActivity(create);
    }
}

