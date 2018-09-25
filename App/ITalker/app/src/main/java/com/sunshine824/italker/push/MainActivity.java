package com.sunshine824.italker.push;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sunshine824.common.Common;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Common();
    }
}
