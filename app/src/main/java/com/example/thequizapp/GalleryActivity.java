package com.example.thequizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.thequizapp.adapter.GalleryAdapter;
import com.example.thequizapp.model.Entry;
import com.example.thequizapp.model.EntryStorage;

import java.util.Collections;
import java.util.Comparator;

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
        setContentView(R.layout.activity_gallery);


        galleryListView = findViewById(R.id.galleryList);
        galleryAdapter = new GalleryAdapter(this, R.layout.gallery_entry, EntryStorage.getImageList().getImageList());
        galleryListView.setAdapter(galleryAdapter);
        includedLayout = findViewById(R.id.includedLayout);
        newEntry = includedLayout.findViewById(R.id.newEntry);
        selectedImage = includedLayout.findViewById(R.id.selectedImage);

        Button sortDescendingButton = findViewById(R.id.sortDescendingButton);
        sortDescendingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check the current sort order and sort accordingly
                if (isSortedAscending) {
                    // Sort descending
                    Collections.sort(EntryStorage.getImageList().getImageList(), new Comparator<Entry>() {
                        @Override
                        public int compare(Entry o1, Entry o2) {
                            return o2.getName().compareTo(o1.getName()); // For descending
                        }
                    });
                } else {
                    // Sort ascending
                    Collections.sort(EntryStorage.getImageList().getImageList(), new Comparator<Entry>() {
                        @Override
                        public int compare(Entry o1, Entry o2) {
                            return o1.getName().compareTo(o2.getName());
                        }
                    });
                }

                // Toggle the sort order for the next click
                isSortedAscending = !isSortedAscending;

                // Notify the adapter of the data change
                galleryAdapter.notifyDataSetChanged();
            }
        });

        newEntry = includedLayout.findViewById(R.id.newEntry);
        newEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GalleryActivity.this, NewEntryActivity.class);

                // Start the activity for result
                startActivityForResult(intent, 91);
            }
        });
        /**
         * Instead of clicking a buttton, you can press the image to remove it
         */
        galleryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Entry clickedItem = galleryAdapter.getItem(position);
                // Remove item from the adapter
                galleryAdapter.remove(clickedItem);
                // Notify adapter of the dataset change
                galleryAdapter.notifyDataSetChanged();
            }
        });
    }

    /**
     * The method is triggered when an activity launched by this activity finishes its operation
     * @param requestCode The integer request code originally supplied to
     *                    startActivityForResult(), allowing you to identify who this
     *                    result came from.
     * @param resultCode The integer result code returned by the child activity
     *                   through its setResult().
     * @param data An Intent, which can return result data to the caller
     *               (various data can be attached to Intent "extras").
     *
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        finish();
        startActivity(getIntent());
    }
}
