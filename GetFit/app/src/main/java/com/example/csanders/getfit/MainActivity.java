package com.example.csanders.getfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.csanders.getfit.Models.Users;
import com.example.csanders.getfit.Tables.DBHandler;
import com.example.csanders.getfit.Views.Home;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button regClick;
    private Button logClick;
    private EditText userName;
    private EditText pass;
    private String name;
    private String password;
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
        DBHandler db = new DBHandler(this);
        boolean doesExist = false;
        //db.addUser(new Users("John", "Doe", 300, 67));
        List<Users> users = db.getAllShops();
        for (Users user : users) {
            Log.i("Name: ", user.getFirstName());
            Log.i("Input: ", name);
            Log.i("Bool: ", Boolean.toString(doesExist));
            if (user.getFirstName().equals(name)) {
                doesExist = true;
                Log.i("Bool: ", Boolean.toString(doesExist));
            }
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
                  Intent intent = new Intent(this, Home.class);
                  startActivity(intent);
                break;

        }
    }
}