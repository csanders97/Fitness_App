package com.example.csanders.getfit.Views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.csanders.getfit.R;

/**
 * Created by Sophie on 5/15/2017.
 */

public class Library extends Activity {

    private Button create;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        create = (Button)findViewById(R.id.createItemBtn);

    }


    public void CreateOnClick(View view) {

        Intent create = new Intent(this, Create.class);
        startActivity(create);
    }
}
