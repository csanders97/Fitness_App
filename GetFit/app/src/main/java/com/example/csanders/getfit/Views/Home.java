package com.example.csanders.getfit.Views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.csanders.getfit.Models.Users;
import com.example.csanders.getfit.R;
import com.example.csanders.getfit.Tables.DBHandler;

/**
 * Created by Matthew Balderas on 5/15/2017.
 */

public class Home extends Activity implements View.OnClickListener {
    private Button prof;
    private Button lib;
    private Button search;
    DBHandler db = new DBHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Bundle bundle = getIntent().getExtras();
        String use = bundle.getString("stuff");
        int ID = Integer.parseInt(use);
        Users testString = db.getUsers(ID);
        Log.i("Name: ", testString.getFirstName());
        prof = (Button) findViewById(R.id.profileBtn);
        lib = (Button) findViewById(R.id.libraryBtn);
        search = (Button) findViewById(R.id.searchBtn);
        prof.setOnClickListener(this);
        lib.setOnClickListener(this);
        search.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.profileBtn:
                Intent profile = new Intent(this, Profile.class);
                startActivity(profile);
                break;
            case R.id.libraryBtn:
                Intent library = new Intent(this, Library.class);
                startActivity(library);
                break;
            case R.id.searchBtn:
                Intent search = new Intent(this, Search.class);
                startActivity(search);
                break;
        }
    }
}

