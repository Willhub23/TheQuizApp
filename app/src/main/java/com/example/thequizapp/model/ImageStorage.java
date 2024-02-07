package com.example.thequizapp.model;

import android.app.Application;
import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;

import com.example.thequizapp.R;

public class ImageStorage extends Application {

    private static ImageItemList imageList;


    @Override
    public void onCreate() {
        super.onCreate();
        ImageStorage.imageList = new ImageItemList();
        imageToUriAndStore(R.drawable.danmark, "Danmark");
        imageToUriAndStore(R.drawable.england, "England");
        imageToUriAndStore(R.drawable.england, "Kina");
        imageToUriAndStore(R.drawable.norge, "Norge");
        imageToUriAndStore(R.drawable.england, "Spania");
    }

    public static ImageItemList getImageList() {
        return imageList;
    }


    public static void setItemList(ImageItemList itemList) {
        ImageStorage.imageList = itemList;
    }


    public void imageToUriAndStore(int imageId, String name) {
        Uri imageUri = new Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(getResources().getResourcePackageName(imageId))
                .appendPath(getResources().getResourceTypeName(imageId))
                .appendPath(getResources().getResourceEntryName(imageId))
                .build();
            imageList.add(new ImageItem(imageUri, name));

        }
    }
