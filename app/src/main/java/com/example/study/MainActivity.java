package com.example.study;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.imageview.ShapeableImageView;

public class MainActivity extends AppCompatActivity {

    ShapeableImageView math,che,phe,bio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        math = findViewById(R.id.math);
        che=findViewById(R.id.che);
        phe=findViewById(R.id.phe);
        bio=findViewById(R.id.bio);

        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MathActivity.class);
                startActivity(intent);
                finish();
            }
        });

        che.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChemistryActivity.class);
                startActivity(intent);
                finish();
            }
        });

        phe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PhysicsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        bio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BiologyActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
