package com.example.study;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.imageview.ShapeableImageView;

public class MainActivity extends AppCompatActivity {

    ShapeableImageView math;
    ShapeableImageView che;
    //ShapeableImageView phe;
    ShapeableImageView bio;
    ActivityFactory activityFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        math = findViewById(R.id.math);
        che = findViewById(R.id.che);
        //phe = findViewById(R.id.phe);
        bio = findViewById(R.id.bio);

        activityFactory = new ActivityFactory();

        setOnClickListener(math, MathActivity.class);
        setOnClickListener(che, ChemistryActivity.class);
        //setOnClickListener(phe, PhysicsActivity.class);
        setOnClickListener(bio, BiologyActivity.class);
    }

    private void setOnClickListener(ShapeableImageView imageView, final Class<?> activityClass) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(activityFactory.createActivity(MainActivity.this, activityClass));
                finish();
            }
        });
    }
}
