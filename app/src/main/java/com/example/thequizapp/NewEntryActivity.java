package com.example.thequizapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.thequizapp.model.Entry;
import com.example.thequizapp.model.EntryStorage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewEntryActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;  // Constant to identify the image picker request

    private ImageView imageView;  // ImageView to display the selected image
    private EditText nameEditText;  // EditText for user to enter the name associated with the image
    private Button addImageButton;  // Button to trigger the image picker
    private Button saveButton;  // Button to save the new entry

    private Uri imageUri;  // URI to store the selected image

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);  // Set the layout for this activity

        imageView = findViewById(R.id.image_view);  // Find the ImageView in the layout
        nameEditText = findViewById(R.id.edit_text_name);  // Find the EditText in the layout
        addImageButton = findViewById(R.id.button_add_image);  // Find the add image Button in the layout
        saveButton = findViewById(R.id.button_save);  // Find the save Button in the layout

        // Set an OnClickListener on the add image button to open the image picker
        addImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagePicker();
            }
        });

        // Set an OnClickListener on the save button to save the entry
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageUri == null || nameEditText.getText() == null) // Ensure image and name are not null
                    return;

                // Create a new Entry object
                Entry newEntry = new Entry(imageUri.toString(), nameEditText.getText().toString().trim());
                // Add the entry to the in-memory storage
                EntryStorage.getImageList().add(newEntry);
                // Save the entry to the database
                saveEntryToDatabase(newEntry);
                finish();  // Close the activity
            }
        });
    }

    /**
     * Opens the image picker to select an image, and uses an implicit intent since it does not specify a component
     * but rather an action to be performed.
     * But this means it could be susceptible to an implicit intent hijacking because:
     * If an attacker has installed a malicious app on the user's device that declares
     * support for the ACTION_GET_CONTENT action with the image/* MIME type, they could intercept the implicit intent
     * and redirect it to their app instead of the legitimate app chosen by the user
     */
    private void openImagePicker() {
        Intent intent = new Intent();  // Create a new Intent
        intent.setType("image/*");  // Set the intent type to image
        intent.setAction(Intent.ACTION_GET_CONTENT);  // Set the action to get content
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);  // Start the activity to select an image
    }

    /**
     * Handles the result of the image picker activity
     * @param requestCode The integer request code originally supplied to
     *                    startActivityForResult(), allowing you to identify who this
     *                    result came from.
     * @param resultCode The integer result code returned by the child activity
     *                   through its setResult().
     * @param data An Intent, which can return result data to the caller
     *               (various data can be attached to Intent "extras").
     *
     */
    @SuppressLint("WrongConstant") // Suppresses a lint warning for the use of a deprecated constant
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();  // Get the URI of the selected image

            final int takeFlags = data.getFlags()
                    & (Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            // Grant persistable URI permissions to ensure the app can access the image later
            getContentResolver().takePersistableUriPermission(imageUri, takeFlags);

            imageView.setImageURI(imageUri);  // Display the selected image in the ImageView
        }
    }

    /**
     * Saves the entry to the database using a background thread
     * @param entry The entry to save
     */
    private void saveEntryToDatabase(Entry entry) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();  // Create a single-thread executor

        Handler handler = new Handler(Looper.getMainLooper());  // Create a handler to post results to the main thread

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                // Insert the entry into the database
                EntryStorage.entryDatabase.getEntryDAO().insertEntry(entry);

                // Post a runnable to the main thread to show a toast message
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Entry added to database", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
