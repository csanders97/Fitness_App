package com.example.csanders.getfit.Views;

import android.app.Activity;
import android.os.Bundle;

import com.example.csanders.getfit.R;
import com.example.csanders.getfit.Tables.DBHandler;

/**
 * Created by Sophie on 6/2/2017.
 */

public class Item extends Activity {
    DBHandler db = new DBHandler(this);
    int ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        Bundle bundle = getIntent().getExtras();
        String use = bundle.getString("ID");
        ID = Integer.parseInt(use);

        

    }
}
