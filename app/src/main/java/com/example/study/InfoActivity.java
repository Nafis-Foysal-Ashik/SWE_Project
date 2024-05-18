package com.example.study;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    TextView tv;
    Button btn;
    static int count=0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        tv = findViewById(R.id.infotv);
        btn = findViewById(R.id.infobtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(count%3==0)
                {
                    tv.setText("Nafis");
                    count++;
                }
                else if(count%3==1)
                {
                    tv.setText("Hafiz");
                    count++;
                }
                else if(count%3==2)
                {
                    tv.setText("Tomal");
                    count++;
                }
            }
        });

    }
}