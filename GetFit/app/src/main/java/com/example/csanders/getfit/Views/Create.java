package com.example.csanders.getfit.Views;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;

import com.example.csanders.getfit.R;

/**
 * Created by Sophie on 5/15/2017.
 */

public class Create extends Activity {

    RadioButton meal;
    RadioButton workout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        meal  = (RadioButton)findViewById(R.id.mealSelection);
        workout = (RadioButton)findViewById(R.id.workoutSelection);







    }
}
