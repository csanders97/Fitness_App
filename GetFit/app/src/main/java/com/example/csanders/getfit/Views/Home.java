package com.example.csanders.getfit.Views;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.csanders.getfit.R;

/**
 * Created by Matthew Balderas on 5/15/2017.
 */

public class Home extends Activity implements View.OnClickListener {
    private Button prof;
    private Button lib;
    private Button search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
            //case r.id.pro
        }
    }
}

