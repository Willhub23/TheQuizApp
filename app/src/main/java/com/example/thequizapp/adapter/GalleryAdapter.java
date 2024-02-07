package com.example.thequizapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.thequizapp.R;
import com.example.thequizapp.model.ImageItem;

import java.util.List;

public class GalleryAdapter extends ArrayAdapter<ImageItem> {
    private Context aContext;
    private int aResource;

    public GalleryAdapter(@NonNull Context context, int resource, @NonNull List<ImageItem> items) {
        super(context, resource, items);
        this.aContext = context;
        this.aResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = LayoutInflater.from(aContext);

            convertView = layoutInflater.inflate(aResource, parent, false);


            ImageView imageView = convertView.findViewById(R.id.image);
            imageView.setImageURI(getItem(position).getImage());

            TextView textView = convertView.findViewById(R.id.textView);
            textView.setText("LALALAL");



        return convertView;
    }

}