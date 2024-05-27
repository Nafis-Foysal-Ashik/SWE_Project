package com.example.study;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.imageview.ShapeableImageView;

public class Homepage extends AppCompatActivity {

    ImageView quiz,grade,info,hotline;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        quiz = findViewById(R.id.quize);
        grade=findViewById(R.id.grade);
        info=findViewById(R.id.info);
        hotline=findViewById(R.id.call);

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this , MainActivity.class);
                startActivity(intent);
            }
        });

        grade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this , Grade.class);
                startActivity(intent);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this , InfoActivity.class);
                startActivity(intent);
            }
        });

        hotline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this , RecyclerViewActivity.class);
                startActivity(intent);
            }
        });

    }


}