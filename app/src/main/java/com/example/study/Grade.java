package com.example.study;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Grade extends AppCompatActivity {

    EditText edt;
    Button btn;
    TextView tv;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);

        edt = findViewById(R.id.gradedt);
        btn = findViewById(R.id.gradebtn);
        tv = findViewById(R.id.grade_output);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mark = edt.getText().toString();
                int number = Integer.parseInt(mark);

                if(number>100)
                {
                    tv.setText("Please Enter Valid Mark");
                }
                else if(number>=80)
                {
                    tv.setText("Congratulations !!! You have got A+");
                }
                else if(number>=70 && number<80)
                {
                    tv.setText("Congratulations !!! You have got A");
                }

                else if(number>=60 && number<70)
                {
                    tv.setText("Congratulations !!! You have got A-");
                }

                else if(number>=50 && number<60)
                {
                    tv.setText("Congratulations !!! You have got B+");
                }

                else
                {
                    tv.setText("Sorry Your grade is F");
                }

            }
        });

    }
}