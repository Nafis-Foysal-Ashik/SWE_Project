package com.example.study;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BiologyActivity extends AppCompatActivity {
    private TextView questionNumberTextView;
    private TextView questionTextView;
    private RadioButton optionA;
    private RadioButton optionB;
    private RadioButton optionC;
    private RadioButton optionD;
    private Button nextButton;
    private int currentQuestionIndex = 0;
    private List<Question> questionList = new ArrayList<>();
    private RadioGroup optionsGroup;
    private Button show_answerButton;
    private TextView showTotalMark;
    private  int totalmark =0;
    private  Button previousButton,resultButton;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biology);


        questionNumberTextView = findViewById(R.id.question_number);
        questionTextView = findViewById(R.id.question_text);
        optionA = findViewById(R.id.option_a);
        optionB = findViewById(R.id.option_b);
        optionC = findViewById(R.id.option_c);
        optionD = findViewById(R.id.option_d);
        nextButton = findViewById(R.id.next_button);
        optionsGroup = findViewById(R.id.options_group);
        show_answerButton = findViewById(R.id.show_answer);
        showTotalMark = findViewById(R.id.show_total_mark);
        previousButton = findViewById(R.id.previous_button);
        resultButton = findViewById(R.id.result);



        questionList.add(new Question(1, "Which organelle is responsible for cellular respiration?", "Mitochondria", "Chloroplasts", "Nucleus", "Endoplasmic reticulum", "Mitochondria"));
        questionList.add(new Question(2, "What is the basic unit of life?", "Cell", "Tissue", "Organ", "Organism", "Cell"));
        questionList.add(new Question(3, "Which gas is responsible for photosynthesis?", "Oxygen", "Carbon dioxide", "Nitrogen", "Hydrogen", "Carbon dioxide"));
        questionList.add(new Question(4, "What is the process by which plants convert sunlight into energy?", "Photosynthesis", "Cellular respiration", "Transpiration", "Nitrogen fixation", "Photosynthesis"));
        questionList.add(new Question(5, "Which type of cell division produces two identical daughter cells?", "Mitosis", "Meiosis", "Binary fission", "Budding", "Mitosis"));
        questionList.add(new Question(6, "What is the function of DNA?", "To store genetic information", "To produce proteins", "To transport materials", "To provide energy", "To store genetic information"));
        questionList.add(new Question(7, "Which organ system is responsible for regulating blood pressure?", "Cardiovascular system", "Nervous system", "Digestive system", "Respiratory system", "Cardiovascular system"));
        questionList.add(new Question(8, "What is the process by which plants lose water vapor through their leaves?", "Transpiration", "Photosynthesis", "Cellular respiration", "Nitrogen fixation", "Transpiration"));
        questionList.add(new Question(9, "Which type of cell division produces four haploid daughter cells?", "Meiosis", "Mitosis", "Binary fission", "Budding", "Meiosis"));
        questionList.add(new Question(10, "What is the function of RNA?", "To carry genetic information from DNA to the ribosomes", "To produce proteins", "To transport materials", "To provide energy", "To carry genetic information from DNA to the ribosomes"));

        loadQuestion();

       nextButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               currentQuestionIndex++;
               int selectedOptionId = optionsGroup.getCheckedRadioButtonId();
               if(selectedOptionId!=-1)
               {
                   if (currentQuestionIndex < questionList.size()) {
                       RadioButton selectedRadioButton = findViewById(selectedOptionId);
                       String selectedValue = selectedRadioButton.getText().toString();
                       Question currentQuestion = questionList.get(currentQuestionIndex-1);
                       if(selectedValue.equals(currentQuestion.getCorrectOption()))
                           totalmark++;
//                   Toast.makeText(BiologyActivity.this,selectedValue, Toast.LENGTH_SHORT).show();

                       loadQuestion();
                   } else {
                       Toast.makeText(BiologyActivity.this,"No more questions", Toast.LENGTH_SHORT).show();

                   }
               }
               else{
                   if (currentQuestionIndex < questionList.size()){
                       loadQuestion();
                       Toast.makeText(BiologyActivity.this,"You didn't answer previous question", Toast.LENGTH_SHORT).show();
                   }
                   else{
                   Toast.makeText(BiologyActivity.this,"No more questions", Toast.LENGTH_SHORT).show();


                   }

               }

           }
       });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestionIndex > 0) {
                    currentQuestionIndex--;
                    loadQuestion();
                }
                else           Toast.makeText(BiologyActivity.this,"No previous questions.", Toast.LENGTH_SHORT).show();

            }
        });

        show_answerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Question currentQuestion = questionList.get(currentQuestionIndex);
                String correctAnswer = currentQuestion.getCorrectOption();
//                Toast.makeText(BiologyActivity.this,correctAnswer,Toast.LENGTH_SHORT).show();
                highlightCorrectAnswer(correctAnswer);
                highlightWrongAnswer();
            }
        });
        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTotalMark.setText("Total Marks: " + totalmark);
            }
        });

    }
    private void loadQuestion() {
        Question currentQuestion = questionList.get(currentQuestionIndex);
        questionNumberTextView.setText("Question: " + currentQuestion.getId());
        questionTextView.setText(currentQuestion.getQuestion());
        optionA.setText(currentQuestion.getOptionOne());
        optionB.setText(currentQuestion.getOptionTwo());
        optionC.setText(currentQuestion.getOptionThree());
        optionD.setText(currentQuestion.getOptionFour());
        optionsGroup.clearCheck();
        resetOptionsBackground();
    }
    private void highlightCorrectAnswer(String correctAnswer) {

        if (correctAnswer.equals(optionA.getText().toString())) {
            optionA.setBackgroundColor(Color.GREEN);
        } else if (correctAnswer.equals(optionB.getText().toString())) {
            optionB.setBackgroundColor(Color.GREEN);
        } else if (correctAnswer.equals(optionC.getText().toString())) {
            optionC.setBackgroundColor(Color.GREEN);
        } else if (correctAnswer.equals(optionD.getText().toString())) {
            optionD.setBackgroundColor(Color.GREEN);
        }
    }
    private void highlightWrongAnswer() {
        int selectedOptionId = optionsGroup.getCheckedRadioButtonId();
        if (selectedOptionId != -1) { // Check if an option is selected
            RadioButton selectedRadioButton = findViewById(selectedOptionId);
            String selectedValue = selectedRadioButton.getText().toString();
            Question currentQuestion = questionList.get(currentQuestionIndex);
            if (!selectedValue.equals(currentQuestion.getCorrectOption())) {
                selectedRadioButton.setBackgroundColor(Color.RED);
            }
        }
    }

    private void resetOptionsBackground() {
        optionA.setBackgroundColor(Color.TRANSPARENT);
        optionB.setBackgroundColor(Color.TRANSPARENT);
        optionC.setBackgroundColor(Color.TRANSPARENT);
        optionD.setBackgroundColor(Color.TRANSPARENT);
    }

}