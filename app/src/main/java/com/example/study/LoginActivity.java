package com.example.study;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText leditTextmail, leditTextpass;
    Button btnlog, logreg;
    ProgressBar progressBar;
    FirebaseAuthSingleton firebaseAuthSingleton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        leditTextmail=findViewById(R.id.logmail);
        leditTextpass=findViewById(R.id.logpass);
        btnlog = findViewById(R.id.logbtn);
        progressBar = findViewById(R.id.logprog);
        logreg = findViewById(R.id.logreg);

        firebaseAuthSingleton = FirebaseAuthSingleton.getInstance();

        logreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String email = leditTextmail.getText().toString();
                String password = leditTextpass.getText().toString();

                firebaseAuthSingleton.signInWithEmailAndPassword(LoginActivity.this, email, password);
            }
        });
    }
}
