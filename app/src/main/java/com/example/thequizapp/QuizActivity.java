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

    private Entry correct; // The correct entry for the current quiz question
    private int correctPos; // The position of the correct answer in the options list
    private ImageView imageView; // ImageView to display the image for the quiz
    private Button option1Button, option2Button, option3Button; // Buttons for the answer options
    private TextView scoreTextView; // TextView to display the current score
    private List<String> options; // List of answer options for the current question

    private int attempts = 0; // Number of attempts made by the user
    private int currentScore = 0; // Current score of the user

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
        setContentView(R.layout.activity_quiz); // Sets the UI layout for this activity

        this.scoreTextView = findViewById(R.id.scoreTextView); // Initializes the TextView for displaying the score
        updateScore(); // Updates the score display
        startQuiz(); // Starts the quiz by setting up the first question
    }

    /**
     * Handles the answer selected by the user
     *
     * @param index The index of the selected answer
     */
    private void Answer(int index) {
        attempts++; // Increment the number of attempts
        if (correctPos == index) { // Check if the selected answer is correct
            currentScore++; // Increment the score if the answer is correct
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show(); // Show a toast message indicating the correct answer
            startQuiz(); // Start a new quiz question
        } else {
            Toast.makeText(this, "Incorrect, Correct answer: " + correct.getName(), Toast.LENGTH_SHORT).show(); // Show a toast message indicating the incorrect answer
        }

        updateScore(); // Update the score display
    }

    /**
     * Updates the score display in the TextView
     */
    private void updateScore() {
        String text = String.format("Points: %d/%d", currentScore, attempts); // Formats the score as a string
        scoreTextView.setText(text); // Sets the formatted string to the TextView
    }

    /**
     * Starts the quiz by setting up a new question
     */
    private void startQuiz() {
        correct = EntryStorage.getImageList().getRandomImageItem(); // Gets a random correct entry
        options = EntryStorage.getImageList().getThreeRandomAnswers(correct); // Gets three random answer options including the correct one

        imageView = findViewById(R.id.quizImage); // Initializes the ImageView for the quiz image
        imageView.setImageURI(correct.getImage()); // Sets the image for the correct entry in the ImageView

        option1Button = findViewById(R.id.button1); // Initializes the first answer button
        option1Button.setText(options.get(0)); // Sets the text for the first answer button

        option2Button = findViewById(R.id.button2); // Initializes the second answer button
        option2Button.setText(options.get(1)); // Sets the text for the second answer button

        option3Button = findViewById(R.id.button3); // Initializes the third answer button
        option3Button.setText(options.get(2)); // Sets the text for the third answer button

        correctPos = options.indexOf(correct.getName()); // Gets the position of the correct answer in the options list

        // Sets onClickListeners for each button to handle answer selection
        option1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Answer(0); // Passes the index of the selected answer to the Answer method
            }
        });
        option2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Answer(1); // Passes the index of the selected answer to the Answer method
            }
        });
        option3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Answer(2); // Passes the index of the selected answer to the Answer method
            }
        });
    }

    /**
     * Gets the correct entry for the current quiz question
     * @return The correct entry
     */
    public Entry getCorrect() {
        return correct;
    }
}
