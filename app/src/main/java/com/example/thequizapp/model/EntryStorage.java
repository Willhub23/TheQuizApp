package com.example.thequizapp.model;

import android.app.Application;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.thequizapp.R;
import com.example.thequizapp.database.EntryDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Class for managing the list of Entry objects.
 * Extends Application to maintain a global application state.
 */
public class EntryStorage extends Application {

    private static EntryList imageList;
    public static EntryDatabase entryDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize the image list
        EntryStorage.imageList = new EntryList();

        // Define a callback for Room database events
        RoomDatabase.Callback callback = new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
            }

            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db) {
                super.onOpen(db);
            }
        };

        // Build the Room database instance
        entryDatabase = Room
                .databaseBuilder(getApplicationContext(), EntryDatabase.class, "EntryDatabase")
                .addCallback(callback)
                .build();

        // Fetch entries from the database in a background thread
        getEntriesInBackground();
    }

    private void getEntriesInBackground() {
        // Create a single-thread executor for background operations
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Create a handler associated with the main thread's Looper for UI updates
        Handler handler = new Handler(Looper.getMainLooper());

        // Execute a task in the background thread
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                // Fetch the list of entries from the database in the background
                imageList.setImageList(entryDatabase.getEntryDAO().getAllEntries());

                // Post a task to the main thread to update the UI
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        // Show a toast message on the main thread
                        Toast.makeText(getApplicationContext(), "Data fetched", Toast.LENGTH_SHORT).show();

                        // Add default entries if the list has fewer than 3 items
                        if (imageList.getImageList().size() < 3) {
                            imageToUriAndStore(R.drawable.danmark, "Danmark");
                            imageToUriAndStore(R.drawable.england, "England");
                            imageToUriAndStore(R.drawable.kina, "Kina");
                            imageToUriAndStore(R.drawable.norge, "Norge");
                            imageToUriAndStore(R.drawable.spania, "Spania");
                        }
                    }
                });
            }
        });
    }

    // Static method to access the image list from other parts of the application
    public static EntryList getImageList() {
        return imageList;
    }

    /**
     * Converts an image resource ID to a URI and adds it to the imageList with the associated name.
     * @param imageId The resource ID of the image.
     * @param name The name associated with the image.
     */
    public void imageToUriAndStore(int imageId, String name) {
        // Construct a URI for the image resource using a Builder pattern
        Uri imageUri = new Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE) // Set the scheme to indicate an Android resource
                .authority(getResources().getResourcePackageName(imageId)) // Set the authority to the package name of the resource
                .appendPath(getResources().getResourceTypeName(imageId)) // Append the resource type (e.g., "drawable")
                .appendPath(getResources().getResourceEntryName(imageId)) // Append the resource entry name (e.g., "danmark")
                .build();

        // Create a new Entry object with the constructed URI and the provided name
        Entry newEntry = new Entry(imageUri.toString(), name);

        // Add the new Entry to the imageList
        imageList.add(newEntry);

        // Save the new Entry to the database on a background thread
        saveToDatabase(newEntry);
    }


    public void saveToDatabase(Entry entry) {
        // Create a single-thread executor for background operations
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Create a handler associated with the main thread's Looper for UI updates
        Handler handler = new Handler(Looper.getMainLooper());

        // Execute a task in the background thread
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                // Insert the entry into the database in the background
                EntryStorage.entryDatabase.getEntryDAO().insertEntry(entry);

                // Post a task to the main thread to show a toast message
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        // Show a toast message on the main thread
                        Toast.makeText(getApplicationContext(), "Entry saved", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
