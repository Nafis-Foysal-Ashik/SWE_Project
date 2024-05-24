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
    private ChemistryQuiz chemistryQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemistry);

        questionText = findViewById(R.id.question_text);
        answerEditText = findViewById(R.id.answer_edit_text);
        submitButton = findViewById(R.id.submit_button);
        chemistryQuiz = new ChemistryQuiz();

        displayQuestion();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAnswerSubmission();
            }
        });
    }

    private void displayQuestion() {
        String question = chemistryQuiz.getCurrentQuestion();
        questionText.setText(question);
    }

    private void handleAnswerSubmission() {
        String userAnswer = answerEditText.getText().toString().trim();
        if (TextUtils.isEmpty(userAnswer)) {
            showToast("Please enter your answer.");
            return;
        }

        boolean isCorrect = chemistryQuiz.checkAnswer(userAnswer);
        if (isCorrect) {
            showToast("Correct! Your Score: " + chemistryQuiz.getScore());
        } else {
            showToast("Incorrect. The answer is " + chemistryQuiz.getCurrentAnswer());
        }

        if (chemistryQuiz.isLastQuestion()) {
            showToast("Your Score: " + chemistryQuiz.getScore());
        } else {
            chemistryQuiz.moveToNextQuestion();
            displayQuestion();
            answerEditText.setText(""); // Clear answer field for next question
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
