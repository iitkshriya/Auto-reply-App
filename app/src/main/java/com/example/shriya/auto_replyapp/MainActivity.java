package com.example.shriya.auto_replyapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public static EditText messageDefault ;

    public void buttonOnClick (View v) {
        Button button = (Button) v;
        messageDefault = (EditText) findViewById(R.id.txt);
    }

}
