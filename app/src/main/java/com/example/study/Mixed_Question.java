//package com.example.study;
//
//import android.annotation.SuppressLint;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.CheckBox;
//import android.widget.EditText;
//import android.widget.RadioButton;
//import android.widget.RadioGroup;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.study.R;
//
//class MainActivity extends AppCompatActivity {
//
//    private RadioGroup firstRadioGroup;
//    private RadioGroup secondRadioGroup;
//    private EditText thirdQuestionInput;
//    private CheckBox checkBox1;
//    private CheckBox checkBox2;
//    private CheckBox checkBox3;
//    private CheckBox checkBox4;
//    private CheckBox checkBox5;
//    private Button submitButton;
//
//    @SuppressLint("MissingInflatedId")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        firstRadioGroup = findViewById(R.id.first_radio_group);
//        secondRadioGroup = findViewById(R.id.second_radio_group);
//        thirdQuestionInput = findViewById(R.id.third_question_user_input);
//        checkBox1 = findViewById(R.id.fourth_checkbox1);
//        checkBox2 = findViewById(R.id.fourth_checkbox2);
//        checkBox3 = findViewById(R.id.fourth_checkbox3);
//        checkBox4 = findViewById(R.id.fourth_checkbox4);
//        checkBox5 = findViewById(R.id.fourth_checkbox5);
//        submitButton = findViewById(R.id.submit_answer_button);
//
//        submitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                submitAnswer();
//            }
//        });
//    }
//
//    public void submitAnswer() {
//        // First question
//        int firstQuestionSelectedId = firstRadioGroup.getCheckedRadioButtonId();
//        RadioButton firstQuestionSelectedRadioButton = findViewById(firstQuestionSelectedId);
//        String firstQuestionAnswer = firstQuestionSelectedRadioButton == null ? "" : firstQuestionSelectedRadioButton.getText().toString();
//
//        // Second question
//        int secondQuestionSelectedId = secondRadioGroup.getCheckedRadioButtonId();
//        RadioButton secondQuestionSelectedRadioButton = findViewById(secondQuestionSelectedId);
//        String secondQuestionAnswer = secondQuestionSelectedRadioButton == null ? "" : secondQuestionSelectedRadioButton.getText().toString();
//
//        // Third question
//        String thirdQuestionAnswer = thirdQuestionInput.getText().toString().trim();
//
//        // Fourth question
//        StringBuilder fourthQuestionAnswer = new StringBuilder();
//        if (checkBox1.isChecked()) {
//            fourthQuestionAnswer.append(checkBox1.getText().toString()).append(", ");
//        }
//        if (checkBox2.isChecked()) {
//            fourthQuestionAnswer.append(checkBox2.getText().toString()).append(", ");
//        }
//        if (checkBox3.isChecked()) {
//            fourthQuestionAnswer.append(checkBox3.getText().toString()).append(", ");
//        }
//        if (checkBox4.isChecked()) {
//            fourthQuestionAnswer.append(checkBox4.getText().toString()).append(", ");
//        }
//        if (checkBox5.isChecked()) {
//            fourthQuestionAnswer.append(checkBox5.getText().toString()).append(", ");
//        }
//
//        if (fourthQuestionAnswer.length() > 0) {
//            fourthQuestionAnswer.setLength(fourthQuestionAnswer.length() - 2); // Remove the trailing comma and space
//        }
//
//        // Display the answers using Toast
//        String result = "First Question Answer: " + firstQuestionAnswer + "\n" +
//                "Second Question Answer: " + secondQuestionAnswer + "\n" +
//                "Third Question Answer: " + thirdQuestionAnswer + "\n" +
//                "Fourth Question Answer: " + fourthQuestionAnswer.toString();
//
//        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
//    }
//}
