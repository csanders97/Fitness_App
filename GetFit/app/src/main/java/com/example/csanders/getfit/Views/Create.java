package com.example.csanders.getfit.Views;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.csanders.getfit.R;

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
