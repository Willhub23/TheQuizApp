package com.example.thequizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thequizapp.model.Entry;
import com.example.thequizapp.model.EntryStorage;

import java.util.List;


public class QuizActivity extends AppCompatActivity {

    private Entry correct;

    private int correctPos;
    private ImageView imageView;
    private Button option1Button, option2Button, option3Button;
    private TextView scoreTextView;

    private List<String> options;

    private List<Entry> imageList;
    private int attempts = 0;
    private int currentScore = 0;

    /**
     * Initializes the activity and sets up the layout
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        this.scoreTextView = findViewById(R.id.scoreTextView);
        updateScore();
        startQuiz();
    }


    private void Answer(int index) {
        attempts++;
        if (correctPos == index) {
            currentScore++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            startQuiz();
        } else {
            Toast.makeText(this, "Incorrect, Correct answer: " + correct.getName(), Toast.LENGTH_SHORT).show();
        }

        updateScore();

    }

    private void updateScore() {
        String text = String.format("Points: %d/%d", currentScore, attempts); // Converts a int to string to TextView
        scoreTextView.setText(text);

    }


    private void startQuiz() {
        correct = EntryStorage.getImageList().getRandomImageItem();
        options = EntryStorage.getImageList().getThreeRandomAnswers(correct);

        imageView = findViewById(R.id.quizImage);
        imageView.setImageURI(correct.getImage());

        option1Button = findViewById(R.id.button1);
        option1Button.setText(options.get(0));

        option2Button = findViewById(R.id.button2);
        option2Button.setText(options.get(1));

        option3Button = findViewById(R.id.button3);
        option3Button.setText(options.get(2));

        correctPos = options.indexOf(correct.getName());

        option1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Answer(0);
            }
        });
        option2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Answer(1);
            }
        });
        option3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Answer(2);
            }
        });


    }
}