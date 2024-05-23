package com.example.study;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PhysicsActivity extends AppCompatActivity {
    private Button[] buttons = new Button[40];
    private Button btnSb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physics);

        // Initialize buttons
        int[] buttonIds = {
                R.id.q1ap, R.id.q1bp, R.id.q1cp, R.id.q1dp,
                R.id.q2ap, R.id.q2bp, R.id.q2cp, R.id.q2dp,
                R.id.q3ap, R.id.q3bp, R.id.q3cp, R.id.q3dp,
                R.id.q4pa, R.id.q4pb, R.id.q4pc, R.id.q4pd,
                R.id.q5ap, R.id.q5bp, R.id.q5cp, R.id.q5dp,
                R.id.q6ap, R.id.q6bp, R.id.q6cp, R.id.q6dp,
                R.id.q7ap, R.id.q7bp, R.id.q7cp, R.id.q7dp,
                R.id.q8ap, R.id.q8bp, R.id.q8cp, R.id.q8dp,
                R.id.q9ap, R.id.q9bp, R.id.q9cp, R.id.q9dp,
                R.id.q10ap, R.id.q10bp, R.id.q10cp, R.id.q10dp
        };

        for (int i = 0; i < buttonIds.length; i++) {
            buttons[i] = findViewById(buttonIds[i]);
        }

        btnSb = findViewById(R.id.psb);

        // Set up listeners
        setButtonListeners();

        btnSb.setOnClickListener(view ->
                Toast.makeText(PhysicsActivity.this, "Your Score: " + ScoreManager.getInstance().getScore(), Toast.LENGTH_SHORT).show()
        );
    }

    private void setButtonListeners() {
        int[] correctAnswers = {
                R.id.q1cp, R.id.q2ap, R.id.q3dp,
                R.id.q4pb, R.id.q5bp, R.id.q6bp,
                R.id.q7dp, R.id.q8cp, R.id.q9ap,
                R.id.q10cp
        };

        for (int i = 0; i < buttons.length; i++) {
            boolean isCorrect = false;
            for (int correctAnswer : correctAnswers) {
                if (correctAnswer == buttons[i].getId()) {
                    isCorrect = true;
                    break;
                }
            }
            buttons[i].setOnClickListener(new AdapterClickListener(buttons[i], isCorrect, getQuestionButtons(i / 4)));
        }
    }

    private Button[] getQuestionButtons(int questionIndex) {
        Button[] questionButtons = new Button[4];
        System.arraycopy(buttons, questionIndex * 4, questionButtons, 0, 4);
        return questionButtons;
    }

    private class AdapterClickListener implements View.OnClickListener {
        private BtnClick btnClick;
        private Button button;
        private Button[] questionButtons;
        private boolean isCorrect;

        public AdapterClickListener(Button button, boolean isCorrect, Button[] questionButtons) {
            this.button = button;
            this.isCorrect = isCorrect;
            this.questionButtons = questionButtons;
            this.btnClick = isCorrect ? new CorrBtnClick() : new incrBtnClick();
        }

        @Override
        public void onClick(View view) {
            btnClick.onClick();
            button.setBackgroundColor(isCorrect ? 0xFF00FF00 : 0xFFFF0000); // Green for correct, Red for incorrect
            for (Button b : questionButtons) {
                b.setEnabled(false);
            }
        }
    }
}
