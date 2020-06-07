package com.vu.nit6120_lab4_3_passingvalueswithintents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DoSumActivity extends AppCompatActivity {

    private int valueToWorkWith;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_sum);

        //Get the intent from 1st screen
        Intent intent = getIntent();
        valueToWorkWith = intent.getIntExtra("paramter name", 0);

        //Display value to screen
        TextView displayNumber = (TextView) findViewById(R.id.userNumber);
        displayNumber.setText("" + valueToWorkWith);

        setUpDoubleNumber();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void setUpDoubleNumber()
    {
        Button btn = (Button) findViewById(R.id.btnDoubleNumber);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int answer = valueToWorkWith * 2;

                Intent intent = new Intent();
                intent.putExtra("the answer", answer);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

    }

}