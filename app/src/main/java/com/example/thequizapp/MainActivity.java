package com.example.thequizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thequizapp.model.EntryStorage;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button quizButton = findViewById(R.id.quizButton);
        Button galleryButton = findViewById(R.id.galleryButton);

        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (EntryStorage.getImageList().getImageList().size() < 3) {
                    Toast.makeText(MainActivity.this, "Not enough entities for the quiz", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(MainActivity.this, QuizActivity.class));
                }
            }
        });

        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start gallery Activity
                startActivity(new Intent(MainActivity.this, GalleryActivity.class));

            }
        });

    }
}