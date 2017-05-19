package com.example.csanders.getfit.Views;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
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

public class Profile extends Activity {
    DBHandler db = new DBHandler(this);
    MainActivity main = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Bundle bundle = getIntent().getExtras();
        String use = bundle.getString("ID");
        int ID = Integer.parseInt(use);
        Users test = db.getUsers(ID);
        EditText name = (EditText) findViewById(R.id.nameInputProf);
        EditText age = (EditText) findViewById(R.id.ageInputProf);
        EditText weight = (EditText) findViewById(R.id.weightInputProf);
        EditText height = (EditText) findViewById(R.id.heightInputProf);
        name.setText(test.getFirstName(), TextView.BufferType.EDITABLE);
        //weight.setText(test.getWeight());
        //height.setText((int) test.getHeight());
    }


}
