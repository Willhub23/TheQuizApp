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

        // The 'savedInstanceState' parameter is a Bundle containing the activity's previously saved state.
        // This is used to reconstruct the activity's state when it is recreated.
        // It can be null if the activity is being started for the first time.

        // Find quizButton and galleryButton by their IDs
        Button quizButton = findViewById(R.id.quizButton);
        Button galleryButton = findViewById(R.id.galleryButton);

        // Set onClickListener for quizButton
        // An OnClickListener is an interface used for handling click events on a view.
        // It's part of the View class and is commonly used to define actions to be performed
        // when a user clicks a button or interacts with other UI elements.
        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if there are enough entries in the image list to start the quiz
                if (EntryStorage.getImageList().getImageList().size() < 3) {
                    // If not enough entries, display a toast message
                    Toast.makeText(MainActivity.this, "Not enough entities for the quiz", Toast.LENGTH_SHORT).show();
                } else {
                    // If enough entries, start the QuizActivity with an EMPLICIT intent
                    startActivity(new Intent(MainActivity.this, QuizActivity.class));
                }
            }
        });

        // Set onClickListener for galleryButton, is apart of the View
        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start GalleryActivity with an EMPLICIT intent
                startActivity(new Intent(MainActivity.this, GalleryActivity.class));
            }
        });
    }
}
