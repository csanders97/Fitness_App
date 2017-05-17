package com.example.csanders.getfit.Views;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.csanders.getfit.R;

/**
 * Created by Matthew Balderas on 5/15/2017.
 */

public class Home extends Activity {
    private Button prof;
    private Button lib;
    private Button work;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


    }
}

