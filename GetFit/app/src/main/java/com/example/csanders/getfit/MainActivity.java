package com.example.csanders.getfit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.csanders.getfit.Models.Ingredients;
import com.example.csanders.getfit.Models.Meals;
import com.example.csanders.getfit.Models.Users;
import com.example.csanders.getfit.Models.Workouts;
import com.example.csanders.getfit.Tables.DBHandler;
import com.example.csanders.getfit.Views.Home;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button regClick;
    private Button logClick;
    private EditText userName;
    private EditText pass;
    private String name;
    private String password;
    public int currUserID;
    DBHandler db = new DBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        regClick = (Button) findViewById(R.id.registerbtn);
        regClick.setOnClickListener(this);
        logClick = (Button) findViewById(R.id.loginbtn);
        logClick.setOnClickListener(this);
        pass = (EditText) findViewById(R.id.passwordinput);
        password = pass.getText().toString();
    }

    public void onClick(View view) {
        userName = (EditText) findViewById(R.id.usernameinput);
        name = userName.getText().toString();
        boolean doesExist = false;
        //db.addUsers(new Users(1, "John", "hiThere", "Doe", 300, 67));
        //db.addUsers(new Users(2, "Caleb", "hiThere", "Sanders", 150, 59));


// Inserting Shop/Rows
//        Log.d("Insert: ", "Inserting ..");
//        db.addUsers(new Users("Billy", "Bob", 300 , 6));
//        db.addIngredients(new Ingredients(1,"Carrot",10,"Vegatable",1));
//        db.addMeals(new Meals(1,"Salad",190,1,"5-17-2017","Lunch" ," ", " Weight Loss", 1, "Lettuce"));
//        db.addWorkouts(new Workouts(1,"Treadmill" , "Cardio", 30,1));

// Reading all shops
        Log.d("Reading: ", "Reading all users..");
        List<Users> users = db.getAllUsers();
        int userIndex = 0;
        for (Users user : users) {
            Log.i("Name: ", user.getFirstName());
            Log.i("Input: ", name);
            Log.i("Bool: ", Boolean.toString(doesExist));
            if (user.getFirstName().equals(name)) {
                doesExist = true;
                Log.i("Bool: ", Boolean.toString(doesExist));
                break;
            }
            userIndex++;
        }
        switch(view.getId()) {
            case R.id.registerbtn:
                //logic
                break;
            case R.id.loginbtn:
                //logic
                if (doesExist) {
                    Log.i("Login: ", "Welcome back");
                }
                else {
                    Log.i("Login: ", "You need to register this user");
                }
                currUserID = users.get(userIndex).getUserId();
                Users testString = db.getUsers(currUserID);
                Intent intent = new Intent(this, Home.class);
                Bundle bundle = new Bundle();
                bundle.putString("stuff", String.valueOf(currUserID));
                intent.putExtras(bundle);
                startActivity(intent);
                break;
        }
    }
}