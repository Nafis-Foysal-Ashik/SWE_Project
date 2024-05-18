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
    GradeCalculator calculator;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);

        edt = findViewById(R.id.gradedt);
        btn = findViewById(R.id.gradebtn);
        tv = findViewById(R.id.grade_output);
        calculator = new GradeCalculator();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mark = edt.getText().toString();
                int number = Integer.parseInt(mark);
                String grade = calculator.calculateGrade(number);
                tv.setText(grade);
            }
        });
    }
}
