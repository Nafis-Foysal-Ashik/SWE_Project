package com.example.study;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.study.R;

import java.util.HashSet;
import java.util.Set;

public class MathActivity extends AppCompatActivity {

    Button[] buttons,redButtons;
    Set<Integer> clickedButtons;//: A Set to track which buttons have been clicked.
    Integer count = 0;
    MathQuizModel mathQuizModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        buttons = new Button[]{
                findViewById(R.id.q1bm),
                findViewById(R.id.q2bm),
                findViewById(R.id.q3cm),
                findViewById(R.id.q4cm),
                findViewById(R.id.q5dm),
                findViewById(R.id.q6cm),
                findViewById(R.id.q7dm),
                findViewById(R.id.q8dm),
                findViewById(R.id.q9bm),
                findViewById(R.id.q10cm)
        };

        redButtons = new Button[]{
                findViewById(R.id.q1am),
                findViewById(R.id.q1cm),
                findViewById(R.id.q1dm),

                findViewById(R.id.q2am),
                findViewById(R.id.q2cm),
                findViewById(R.id.q2dm),

                findViewById(R.id.q3am),
                findViewById(R.id.q3bm),
                findViewById(R.id.q3dm),

                findViewById(R.id.q4am),
                findViewById(R.id.q4bm),
                findViewById(R.id.q4dm),

                findViewById(R.id.q5am),
                findViewById(R.id.q5bm),
                findViewById(R.id.q5cm),

                findViewById(R.id.q6am),
                findViewById(R.id.q6bm),
                findViewById(R.id.q6dm),

                findViewById(R.id.q7am),
                findViewById(R.id.q7bm),
                findViewById(R.id.q7cm),

                findViewById(R.id.q8am),
                findViewById(R.id.q8bm),
                findViewById(R.id.q8cm),

                findViewById(R.id.q9am),
                findViewById(R.id.q9cm),
                findViewById(R.id.q9dm),

                findViewById(R.id.q10am),
                findViewById(R.id.q10bm),
                findViewById(R.id.q10dm)




        };

        clickedButtons = new HashSet<>();//HashSet to track button clicks, ensuring each button is only counted once.

        // Use the singleton instance of MathQuizModel
        mathQuizModel = MathQuizModel.getInstance();

        for (Button button : buttons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int buttonId = v.getId();
                    if (!clickedButtons.contains(buttonId)) {
                        count++;
                        clickedButtons.add(buttonId);
                        // Change button background color to green
                        button.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    }
                }
            });
        }

        //redButtons
        clickedButtons.clear();

        for (Button button : redButtons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int buttonId = v.getId();
                    if (!clickedButtons.contains(buttonId)) {
                        clickedButtons.add(buttonId);
                        // Change button background color to green
                        button.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    }
                }
            });
        }
        Button submitButton = findViewById(R.id.submath);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display count value
                Toast.makeText(MathActivity.this, "Your Score : " + count, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
