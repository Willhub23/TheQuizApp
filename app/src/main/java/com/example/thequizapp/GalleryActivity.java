package com.example.thequizapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.thequizapp.adapter.GalleryAdapter;
import com.example.thequizapp.model.Entry;
import com.example.thequizapp.model.EntryList;
import com.example.thequizapp.model.EntryStorage;

import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Activity class to display a list of images with matching names, and other functionalities
 */
public class GalleryActivity extends AppCompatActivity {

    private boolean isSortedAscending = true; // Tracks the current sorting order

    private ListView galleryListView;

    private GalleryAdapter galleryAdapter; // Adapter for inserting the ListView with gallery items

    private Button newEntry;

    private ImageView selectedImage;

    private View includedLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Sets the UI layout for this activity
        setContentView(R.layout.activity_gallery);

        // Retrieve the list of entries
        EntryList entryList = EntryStorage.getImageList();
        if (entryList != null) {
            // Sort the entry list alphabetically by name
            Collections.sort(entryList.getImageList(), new Comparator<Entry>() {
                @Override
                public int compare(Entry o1, Entry o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });

            // Initialize adapter with sorted entry list
            galleryAdapter = new GalleryAdapter(getApplicationContext(), R.layout.gallery_entry, entryList.getImageList());
        } else {
            Log.d("GalleryActivity", "Entry list is null");
        }

        // Find the ListView in the layout and set the adapter
        galleryListView = findViewById(R.id.galleryList);
        galleryListView.setAdapter(galleryAdapter);

        // Find the included layout and its elements
        includedLayout = findViewById(R.id.includedLayout);
        newEntry = includedLayout.findViewById(R.id.newEntry);
        selectedImage = includedLayout.findViewById(R.id.selectedImage);

        // Find the sort button and set its click listener
        Button sortDescendingButton = findViewById(R.id.sortDescendingButton);
        sortDescendingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check the current sort order and sort accordingly
                if (isSortedAscending) {
                    Collections.sort(EntryStorage.getImageList().getImageList(), new Comparator<Entry>() {
                        @Override
                        public int compare(Entry o1, Entry o2) {
                            return o2.getName().compareTo(o1.getName());
                        }
                    });
                } else {
                    Collections.sort(EntryStorage.getImageList().getImageList(), new Comparator<Entry>() {
                        @Override
                        public int compare(Entry o1, Entry o2) {
                            return o1.getName().compareTo(o2.getName());
                        }
                    });
                }
                // Toggle the sort order flag
                isSortedAscending = !isSortedAscending;

                // Notify the adapter that the data set has changed
                galleryAdapter.notifyDataSetChanged();
            }
        });

        // Set click listener for the new entry button
        newEntry = includedLayout.findViewById(R.id.newEntry);
        newEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the NewEntryActivity to add a new entry
                Intent intent = new Intent(GalleryActivity.this, NewEntryActivity.class);

                // Start the activity for result with a request code of 91
                startActivityForResult(intent, 91); // Explicit Intent
            }
        });

        // Set item click listener for the ListView items
        galleryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the clicked item
                Entry clickedItem = galleryAdapter.getItem(position);
                // Delete the item from the database
                deleteFromDatabase(clickedItem);
                // Remove the item from the adapter
                galleryAdapter.remove(clickedItem);
                // Notify the adapter that the data set has changed
                galleryAdapter.notifyDataSetChanged();
            }
        });
    }

    /**
     * Deletes an entry from the database in a background thread and updates the UI on completion.
     * @param entry The entry to be deleted.
     */
    public void deleteFromDatabase(Entry entry) {
        // Create a new single-thread executor
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Handler for posting back to the main thread
        Handler handler = new Handler(Looper.getMainLooper());

        // Execute database operation in background thread
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                // Delete the entry from the database
                EntryStorage.entryDatabase.getEntryDAO().deleteEntry(entry);

                // Post a message to the main thread using Handler
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        // Display a toast message indicating the entry was deleted
                        Toast.makeText(getApplicationContext(), "Entry deleted from database", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    /**
     * The method is triggered when an activity launched by this activity finishes its operation.
     * @param requestCode The integer request code originally supplied to startActivityForResult(),
     *                    allowing you to identify who this result came from.
     * @param resultCode The integer result code returned by the child activity through its setResult().
     * @param data An Intent, which can return result data to the caller (various data can be attached
     *             to Intent "extras").
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Refresh the activity to reflect any changes
        finish();
        startActivity(getIntent()); // Explicit Intent
    }
}
