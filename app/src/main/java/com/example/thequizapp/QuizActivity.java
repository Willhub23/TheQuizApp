package com.example.thequizapp;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button option1Button, option2Button, option3Button;
    private TextView scoreTextView;

    private List<Image> imageList;
    private int currentScore = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        imageView = findViewById(R.id.image);
        option1Button = findViewById(R.id.option1Button);
        option2Button = findViewById(R.id.option2Button);
        option3Button = findViewById(R.id.option3Button);
        scoreTextView = findViewById(R.id.scoreTextView);

        startQuiz();
    }

    private void startQuiz() {
        Image selectedImage = getRandomImage();

        List<String> answerOptions = generateAnswerOptions(selectedImage);
        Collections.shuffle(answerOptions);

        displayImage(selectedImage);
        displayAnswerOptions(answerOptions);

        option1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(selectedImage, answerOptions.get(0));
            }
        });

        option2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(selectedImage, answerOptions.get(1));
            }
        });

        option3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(selectedImage, answerOptions.get(2));
            }
        });

    }

    private Image getRandomImage() {

        return null;
    }

    private List<String> generateAnswerOptions(Image image) {

        return null;
    }

    private void displayImage(Image image) {

    }

    private void checkAnswer(Image image, String selectedOption) {

    }

    private void displayAnswerOptions(List<String> options) {
        option1Button.setText(options.get(0));
        option2Button.setText(options.get(1));
        option3Button.setText(options.get(2));
    }



}
