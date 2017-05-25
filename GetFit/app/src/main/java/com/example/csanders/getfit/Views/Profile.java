package com.example.csanders.getfit.Views;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Bundle bundle = getIntent().getExtras();
        String use = bundle.getString("ID");
        ID = Integer.parseInt(use);
        test = db.getUsers(ID);
        userName = (EditText)findViewById(R.id.nameInputProf);
        age = (EditText) findViewById(R.id.ageInputProf);
        weight = (EditText) findViewById(R.id.weightInputProf);
        height = (EditText) findViewById(R.id.heightInputProf);
        userName.setText(test.getUserName(), TextView.BufferType.EDITABLE);
        age.setText(String.valueOf(test.getAge()), TextView.BufferType.EDITABLE);
        weight.setText(String.valueOf(test.getWeight()), TextView.BufferType.EDITABLE);
        height.setText(String.valueOf(test.getHeight()), TextView.BufferType.EDITABLE);
//        dailyCalories = (TextView) findViewById(R.id.dailyCalories);
//        Double daily = findCalories();
//        String calorie = new Double(daily).toString();
//        dailyCalories.setText(calorie);
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
        goal = (Spinner) findViewById(R.id.goalsSpinner);
        String agenda = goal.getSelectedItem().toString();
        db.updateUser(ID, getName, getAge, getWeight, getHeight, agenda);
        finish();
        startActivity(getIntent());
    }

    public double findCalories() {
        double calories = 0;
        int userAge = Integer.parseInt(age.toString());
        int userWeight = Integer.parseInt(weight.toString());
        int userHeight = Integer.parseInt(height.toString());
        calories = (10*(userWeight*.45359237) + (6.25 * (userHeight*2.54) - (5*userAge) + 5));
        if(goal.getSelectedItem().toString().contains("Lose Weight")) {
            calories -= 500;
        }
        if(goal.getSelectedItem().toString().contains("Gain Weight")) {
            calories += 500;
        }
        return calories;
    }
}
