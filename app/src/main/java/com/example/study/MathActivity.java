package com.example.study;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.study.R;

import java.util.HashSet;
import java.util.Set;

public class MathActivity extends AppCompatActivity {

    Button[] correctButtons;
    Button[] allButtons;
    Set<Integer> clickedButtons;
    TextView showw;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        correctButtons = new Button[]{
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
        showw = findViewById(R.id.result_show);

        allButtons = new Button[]{
                findViewById(R.id.q1am), findViewById(R.id.q1bm), findViewById(R.id.q1cm), findViewById(R.id.q1dm),
                findViewById(R.id.q2am), findViewById(R.id.q2bm), findViewById(R.id.q2cm), findViewById(R.id.q2dm),
                findViewById(R.id.q3am), findViewById(R.id.q3bm), findViewById(R.id.q3cm), findViewById(R.id.q3dm),
                findViewById(R.id.q4am), findViewById(R.id.q4bm), findViewById(R.id.q4cm), findViewById(R.id.q4dm),
                findViewById(R.id.q5am), findViewById(R.id.q5bm), findViewById(R.id.q5cm), findViewById(R.id.q5dm),
                findViewById(R.id.q6am), findViewById(R.id.q6bm), findViewById(R.id.q6cm), findViewById(R.id.q6dm),
                findViewById(R.id.q7am), findViewById(R.id.q7bm), findViewById(R.id.q7cm), findViewById(R.id.q7dm),
                findViewById(R.id.q8am), findViewById(R.id.q8bm), findViewById(R.id.q8cm), findViewById(R.id.q8dm),
                findViewById(R.id.q9am), findViewById(R.id.q9bm), findViewById(R.id.q9cm), findViewById(R.id.q9dm),
                findViewById(R.id.q10am), findViewById(R.id.q10bm), findViewById(R.id.q10cm), findViewById(R.id.q10dm)
        };

        clickedButtons = new HashSet<>();

        // Set listeners for all buttons
        for (Button button : allButtons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    handleButtonClick(v);
                }
            });
        }

        Button submitButton = findViewById(R.id.submath);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showw.setText("Your Score: "+count);
                Toast.makeText(MathActivity.this, "Your Score: " + count, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void handleButtonClick(View v) {
        int buttonId = v.getId();
        // debugging
        String buttonName = getResources().getResourceEntryName(buttonId);
        Log.d("TAG", "Button Name: " + buttonName);
        int questionNumber = getQuestionNumber(buttonId);

        if (!clickedButtons.contains(questionNumber)) {
            clickedButtons.add(questionNumber);
            Button btn = findViewById(buttonId);

            if (isCorrectButton(buttonId)) {
                btn.setBackgroundColor(Color.GREEN);
//                btn.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                count++;
            } else {
                btn.setBackgroundColor(Color.RED);
//                button.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            }
        }
    }

    private int getQuestionNumber(int buttonId) {
        String buttonName = getResources().getResourceEntryName(buttonId);
        return Integer.parseInt(buttonName.substring(1, buttonName.length() - 2));
    }

    private boolean isCorrectButton(int buttonId) {
        for (Button button : correctButtons) {
            if (button.getId() == buttonId) {
                return true;
            }
        }
        return false;
    }
}
