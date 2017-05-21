package com.example.csanders.getfit.Views;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.csanders.getfit.MainActivity;
import com.example.csanders.getfit.Models.Users;
import com.example.csanders.getfit.R;
import com.example.csanders.getfit.Tables.DBHandler;

import java.util.List;

/**
 * Created by Sophie on 5/15/2017.
 */

public class Profile extends Activity implements View.OnClickListener {
    DBHandler db = new DBHandler(this);
    private EditText age;
    private EditText userName;
    private EditText weight;
    private EditText height;
    private Button editUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Bundle bundle = getIntent().getExtras();
        String use = bundle.getString("ID");
        int ID = Integer.parseInt(use);
        Users test = db.getUsers(ID);
        userName = (EditText)findViewById(R.id.nameInputProf);
        age = (EditText) findViewById(R.id.ageInputProf);
        weight = (EditText) findViewById(R.id.weightInputProf);
        height = (EditText) findViewById(R.id.heightInputProf);
        userName.setText(test.getUserName(), TextView.BufferType.EDITABLE);
        age.setText(String.valueOf(test.getAge()), TextView.BufferType.EDITABLE);
        weight.setText(String.valueOf(test.getWeight()), TextView.BufferType.EDITABLE);
        height.setText(String.valueOf(test.getHeight()), TextView.BufferType.EDITABLE);
        editUser = (Button) findViewById(R.id.submitButton);
        editUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        userName = (EditText) findViewById(R.id.nameInputProf);
        age = (EditText) findViewById(R.id.ageInputProf);
        weight = (EditText) findViewById(R.id.weightInputProf);
        height = (EditText) findViewById(R.id.heightInputProf);
        
    }
}
