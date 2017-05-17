package com.example.csanders.getfit.Views;

import android.app.Activity;
import android.os.Bundle;

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
    List<Users> users = db.getAllUsers();
    MainActivity main = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

    }


}
