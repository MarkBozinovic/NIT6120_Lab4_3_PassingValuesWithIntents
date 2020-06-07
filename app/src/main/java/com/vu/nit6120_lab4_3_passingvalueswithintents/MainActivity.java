package com.vu.nit6120_lab4_3_passingvalueswithintents;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpDoSumButton();
    }

    private void setUpDoSumButton()
    {


        Button btn = (Button) findViewById(R.id.doubleNumber);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EditText userTextEntry = (EditText) findViewById(R.id.editTextUserNumber);
                String userData = userTextEntry.getText().toString();
                int userNumber = Integer.parseInt(userData);

                Intent intent = new Intent(MainActivity.this, DoSumActivity.class);
                intent.putExtra("paramter name", userNumber);
                startActivityForResult(intent, 42);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode)
        {
            case 42:
                int answer = data.getIntExtra("the answer", 0);
                TextView answerView = (TextView) findViewById(R.id.textViewAnswer);
                answerView.setText("" + answer);
                break;
        }
    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/
}
