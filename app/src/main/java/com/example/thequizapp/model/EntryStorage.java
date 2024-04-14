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
 * Class for managing the list of ImageItem objects
 */
public class EntryStorage extends Application {

    private static EntryList imageList;
    public static EntryDatabase entryDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        EntryStorage.imageList = new EntryList();

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

        entryDatabase = Room
                .databaseBuilder(getApplicationContext(), EntryDatabase.class, "EntryDatabase")
                        .addCallback(callback)
                                .build();

        getEntriesInBackground();
     }

    private void getEntriesInBackground() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Handler handler = new Handler(Looper.getMainLooper());

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                imageList.setImageList(entryDatabase.getEntryDAO().getAllEntries());

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Data fetched", Toast.LENGTH_SHORT).show();

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

    // static because we will access it throughout the application
    public static EntryList getImageList() {
        return imageList;
    }

    /**
     * Converts an image resource ID to a URI and adds it to the imageList with the associated name
     * @param imageId The resource ID of the image
     * @param name The name associated with the image
     */

    public void imageToUriAndStore(int imageId, String name) {
        Uri imageUri = new Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(getResources().getResourcePackageName(imageId))
                .appendPath(getResources().getResourceTypeName(imageId))
                .appendPath(getResources().getResourceEntryName(imageId))
                .build();
        Entry newEntry = new Entry(imageUri.toString(), name);
        imageList.add(newEntry);
        saveToDatabase(newEntry);
    }

    public void saveToDatabase(Entry entry) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Handler handler = new Handler(Looper.getMainLooper());

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                EntryStorage.entryDatabase.getEntryDAO().insertEntry(entry);

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Data fetched", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}