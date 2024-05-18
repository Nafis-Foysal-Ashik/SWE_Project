package com.example.study;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.imageview.ShapeableImageView;

public class MainActivity extends AppCompatActivity {

    ShapeableImageView math;
    ShapeableImageView che;
    ShapeableImageView phe;
    ShapeableImageView bio;
    ActivityFactory activityFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        math = findViewById(R.id.math);
        che = findViewById(R.id.che);
        phe = findViewById(R.id.phe);
        bio = findViewById(R.id.bio);

        activityFactory = new ActivityFactory();

        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(activityFactory.createActivity(MainActivity.this, MathActivity.class));
                finish();
            }
        });

        che.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(activityFactory.createActivity(MainActivity.this, ChemistryActivity.class));
                finish();
            }
        });

        phe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(activityFactory.createActivity(MainActivity.this, PhysicsActivity.class));
                finish();
            }
        });

        bio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(activityFactory.createActivity(MainActivity.this, BiologyActivity.class));
                finish();
            }
        });
    }
}
