package com.example.study;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChemistryActivity extends AppCompatActivity {

    private TextView questionText;
    private EditText answerEditText;
    private Button submitButton;

    private final String[] questions = {
            "What is the symbol for sodium?",
            "What is the basic unit of mass in the SI system?",
            "What is the process of converting a gas into a liquid?",
            "Which of the following is an alkali metal?",
            "What is the formula for water?"
    };

    private final String[] answers = {
            "Na",
            "gram",
            "condensation",
            "lithium",
            "H2O"
    };

    static int count=0;
    private int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemistry);

        questionText = findViewById(R.id.question_text);
        answerEditText = findViewById(R.id.answer_edit_text);
        submitButton = findViewById(R.id.submit_button);

        displayQuestion(currentQuestionIndex);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userAnswer = answerEditText.getText().toString().trim();
                if (TextUtils.isEmpty(userAnswer)) {
                    Toast.makeText(ChemistryActivity.this, "Please enter your answer.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Check answer (case-insensitive)
                String lowerCaseUserAnswer = userAnswer.toLowerCase();
                if (lowerCaseUserAnswer.equals(answers[currentQuestionIndex].toLowerCase())) {
                    count++;
                    Toast.makeText(ChemistryActivity.this, "Correct! Your Score: " + count, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ChemistryActivity.this, "Incorrect. The answer is " + answers[currentQuestionIndex], Toast.LENGTH_SHORT).show();
                }

                if (currentQuestionIndex == questions.length - 1) {
                    Toast.makeText(ChemistryActivity.this, "Your Score: " + count, Toast.LENGTH_SHORT).show();
                } else {
                    currentQuestionIndex++;
                    displayQuestion(currentQuestionIndex);
                    answerEditText.setText(""); // Clear answer field for next question
                }
            }
        });
    }

    private void displayQuestion(int index) {
        questionText.setText(questions[index]);
    }
}
