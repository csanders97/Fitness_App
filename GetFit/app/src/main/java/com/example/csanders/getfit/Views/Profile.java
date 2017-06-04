package com.example.csanders.getfit.Views;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.csanders.getfit.MainActivity;
import com.example.csanders.getfit.Models.Users;
import com.example.csanders.getfit.R;
import com.example.csanders.getfit.Tables.DBHandler;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Sophie on 5/15/2017.
 */

public class Profile extends Activity implements View.OnClickListener {
    DBHandler db = new DBHandler(this);
    Users test = new Users();
    private EditText age;
    private int ID;
    private EditText userName;
    private EditText weight;
    private EditText height;
    private Button editUser;
    private Spinner goal;
    private TextView dailyCalories;
    private String calorie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Bundle bundle = getIntent().getExtras();
        String use = bundle.getString("ID");
        ID = Integer.parseInt(use);
        test = db.getUsers(ID);
        goal = (Spinner) findViewById(R.id.goalsSpinner);
        userName = (EditText)findViewById(R.id.nameInputProf);
        age = (EditText) findViewById(R.id.ageInputProf);
        weight = (EditText) findViewById(R.id.weightInputProf);
        height = (EditText) findViewById(R.id.heightInputProf);
        userName.setText(test.getUserName(), TextView.BufferType.EDITABLE);
        age.setText(String.valueOf(test.getAge()), TextView.BufferType.EDITABLE);
        weight.setText(String.valueOf(test.getWeight()), TextView.BufferType.EDITABLE);
        height.setText(String.valueOf(test.getHeight()), TextView.BufferType.EDITABLE);
        dailyCalories = (TextView) findViewById(R.id.recCalories);
        goal.setSelection(getSpinnerValue(goal, test.getGoal()));
        if (isEmpty()) {
            calorie = String.valueOf(test.getCaloriequota());
        }
        else  {
            calorie = "Please fill in all empty values.";
        }

        dailyCalories.setText(calorie);
        editUser = (Button) findViewById(R.id.submitButton);
        editUser.setOnClickListener(this);
     }

    @Override
    public void onClick(View view) {
        userName = (EditText) findViewById(R.id.nameInputProf);
        String getName = userName.getText().toString();
        age = (EditText) findViewById(R.id.ageInputProf);
        int getAge = Integer.parseInt(age.getText().toString());
        weight = (EditText) findViewById(R.id.weightInputProf);
        int getWeight = Integer.parseInt(weight.getText().toString());
        height = (EditText) findViewById(R.id.heightInputProf);
        Double getHeight = Double.parseDouble(height.getText().toString());
        String agenda = goal.getSelectedItem().toString();
        Double quota = findCalories();
        db.updateUser(ID, getName, getAge, getWeight, getHeight, agenda, quota);
        finish();
        startActivity(getIntent());
    }

    public boolean isEmpty() {
        if (test.getAge() == 0 || test.getHeight() == 0 || test.getWeight() == 0) {
            return false;
        }
        return true;
    }

    public int getSpinnerValue(Spinner spinner, String userGoal) {
        int index = 0;
        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(userGoal)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public double findCalories() {
        double calories = 0.00;
        double userAge = Double.parseDouble(age.getText().toString());
        double userWeight = Double.parseDouble(weight.getText().toString());
        double userHeight = Double.parseDouble(height.getText().toString());
        calories = (10*(userWeight*.45) + (6.25 * (userHeight*2.5) - (5*userAge) + 5));
        Log.i("Goal: ", goal.getSelectedItem().toString());
        if(goal.getSelectedItem().toString().contains("Lose Weight")) {
            calories -= 500;
        }
        if(goal.getSelectedItem().toString().contains("Gain Weight")) {
            calories += 500;
        }
        return calories;
    }
}