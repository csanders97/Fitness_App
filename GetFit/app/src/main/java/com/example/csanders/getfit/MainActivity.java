package com.example.csanders.getfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.csanders.getfit.Models.Users;
import com.example.csanders.getfit.Tables.DBHandler;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button regClick;
    private Button logClick;
    private EditText userName;
    private EditText pass;
    private String user;
    private String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        regClick = (Button) findViewById(R.id.registerbtn);
        regClick.setOnClickListener(this);
        logClick = (Button) findViewById(R.id.loginbtn);
        logClick.setOnClickListener(this);
        userName = (EditText) findViewById(R.id.usernameinput);
        user = userName.getText().toString();
        pass = (EditText) findViewById(R.id.passwordinput);
        password = pass.getText().toString();
        DBHandler db = new DBHandler(this);

// Inserting Shop/Rows
        Log.d("Insert: ", "Inserting ..");
        db.addUser(new Users("Billy ", "Bob ", 300 , 6 ));

// Reading all shops
        Log.d("Reading: ", "Reading all shops..");
        List<Users> users = db.getAllShops();

        for (Users user : users) {
            String log = "Id: " + user.getUserId() + ",FirstName: " + user.getFirstName() + ",LastName: " + user.getLastName() + ",Weight: " + user.getWeight() + ",Height: " + user.getHeight();
// Writing shops to log
            Log.d("Users: : ", log);
        }
    }


    @Override
    public void onClick(View v) {

    }
}