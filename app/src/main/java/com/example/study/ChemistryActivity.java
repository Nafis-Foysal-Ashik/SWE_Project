package com.example.study;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChemistryActivity extends AppCompatActivity {

    private static ChemistryActivity instance;

    EditText[] editTexts;
    Button[] buttons;
    Question[] questions;

    ChemistryActivity() {
    }

    public static ChemistryActivity getInstance() {
        if (instance == null) {
            instance = new ChemistryActivity();
        }
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemistry);

        // Initialize EditTexts and Buttons
        editTexts = new EditText[]{
                findViewById(R.id.edt1),
                findViewById(R.id.edt2),
                findViewById(R.id.edt3),
                findViewById(R.id.edt4),
                findViewById(R.id.edt5)
        };
        buttons = new Button[]{
                findViewById(R.id.s1b),
                findViewById(R.id.s2b),
                findViewById(R.id.s3b),
                findViewById(R.id.s4b),
                findViewById(R.id.s5b)
        };

        // Initialize Questions
        questions = new Question[]{
                new Question1(),
                new Question2(),
                new Question3(),
                new Question4(),
                new Question5()
        };

        // Set click listeners for each button
        for (int i = 0; i < buttons.length; i++) {
            final int index = i;
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String answer = editTexts[index].getText().toString();
                    boolean isCorrect = questions[index].checkAnswer(answer);
                    if (isCorrect) {
                        Toast.makeText(ChemistryActivity.this, "Congratulations! Your answer is correct", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ChemistryActivity.this, "Sorry, your answer is wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    public interface Question {
        boolean checkAnswer(String answer);
    }

    class Question1 implements Question {
        @Override
        public boolean checkAnswer(String answer) {
            return answer.equalsIgnoreCase("H2O");
        }
    }

    class Question2 implements Question {
        @Override
        public boolean checkAnswer(String answer) {
            return answer.equalsIgnoreCase("6");
        }
    }

    class Question3 implements Question {
        @Override
        public boolean checkAnswer(String answer) {
            return answer.equalsIgnoreCase("Au");
        }
    }

    class Question4 implements Question {
        @Override
        public boolean checkAnswer(String answer) {
            return answer.equalsIgnoreCase("7");
        }
    }

    class Question5 implements Question {
        @Override
        public boolean checkAnswer(String answer) {
            return answer.equalsIgnoreCase("50");
        }
    }
}
