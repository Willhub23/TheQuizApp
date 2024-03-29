package com.example.thequizapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.thequizapp.model.Entry;
import com.example.thequizapp.model.EntryStorage;

public class NewEntryActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;

    private ImageView imageView;
    private EditText nameEditText;
    private Button addImageButton;
    private Button saveButton;

    private Uri imageUri;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);

        imageView = findViewById(R.id.image_view);
        nameEditText = findViewById(R.id.edit_text_name);
        addImageButton = findViewById(R.id.button_add_image);
        saveButton = findViewById(R.id.button_save);

        addImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagePicker();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveEntry();
            }
        });
    }

    /**
     * Opens the image picker to select an image
     */
    private void openImagePicker() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
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
    @SuppressLint("WrongConstant") //
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();

            final int takeFlags = data.getFlags()
                    & (Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            // Check for the freshest data.
            getContentResolver().takePersistableUriPermission(imageUri, takeFlags);

            imageView.setImageURI(imageUri);
        }
    }


    private void saveEntry() {
        String name = nameEditText.getText().toString().trim();
        if (name.isEmpty() || imageUri == null) {
            Toast.makeText(this, "Select an image and enter a name", Toast.LENGTH_SHORT).show();
            return;
        }
        // Save the image and name
        Entry entry = new Entry(imageUri, name);
        EntryStorage.getImageList().add(entry);

        Toast.makeText(this, "Entry added successfully", Toast.LENGTH_SHORT).show();
        finish();
    }
}
