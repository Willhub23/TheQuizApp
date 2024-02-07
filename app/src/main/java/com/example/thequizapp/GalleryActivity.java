package com.example.thequizapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.thequizapp.adapter.GalleryAdapter;
import com.example.thequizapp.model.ImageItem;
import com.example.thequizapp.model.ImageItemList;
import com.example.thequizapp.model.ImageStorage;

import java.util.List;

public class GalleryActivity extends AppCompatActivity {

    private ListView galleryListView;

    private GalleryAdapter galleryAdapter;

    Button newImage;

    ImageView selectedImage;

    View includedLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        ImageStorage.getImageList().sort();

        galleryListView = findViewById(R.id.galleryList);
        galleryAdapter = new GalleryAdapter(this, R.layout.gallery_item, ImageStorage.getImageList().getImageList());
        galleryListView.setAdapter(galleryAdapter);

        includedLayout = findViewById(R.id.includedLayout);
        newImage = includedLayout.findViewById(R.id.newImage);
        selectedImage = includedLayout.findViewById(R.id.selectedImage);

        newImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(GalleryActivity.this, NewOptionActivity.class);

                // dont care its deprecated, the alternative is painful
                //startActivityForResult(intent, 91);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        finish();
        startActivity(getIntent());
    }
}
