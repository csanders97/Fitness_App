package com.example.csanders.getfit.Views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.csanders.getfit.R;
import com.example.csanders.getfit.Tables.DBHandler;

/**
 * Created by Sophie on 5/15/2017.
 */

public class Library extends Activity {

    private Button create;
    TableLayout tl = (TableLayout) findViewById(R.id.tlTable01);
    DBHandler db = new DBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        create = (Button)findViewById(R.id.createItemBtn);

//        for(int i = 0; i < db.length; i++) {
//            TableRow row = new TableRow(this);
//            TextView name = new TextView(this);
//            TextView type = new TextView(this);
//
//            name.setText(db.name);
//            type.setText(db.type);
//
//            row.addView(name);
//            row.addView(type);
//            tl.addView(row);
//        }

    }


    public void CreateOnClick(View view) {

        Intent create = new Intent(this, Create.class);
        startActivity(create);
    }
}

