package com.example.thequizapp.model;

import android.app.Application;
import android.content.ContentResolver;
import android.net.Uri;

import com.example.thequizapp.R;

/**
 * Class for managing the list of ImageItem objects
 */
public class EntryStorage extends Application {

    private static EntryList imageList;


    @Override
    public void onCreate() {
        super.onCreate();
        EntryStorage.imageList = new EntryList();
        imageToUriAndStore(R.drawable.danmark, "Danmark");
        imageToUriAndStore(R.drawable.england, "England");
        imageToUriAndStore(R.drawable.kina, "Kina");
        imageToUriAndStore(R.drawable.norge, "Norge");
        imageToUriAndStore(R.drawable.spania, "Spania");
    }

    // static because we will access it throughout the application
    public static EntryList getImageList() {
        return imageList;
    }


    public static void setItemList(EntryList itemList) {
        EntryStorage.imageList = itemList;
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
            imageList.add(new Entry(imageUri, name));

        }
    }
