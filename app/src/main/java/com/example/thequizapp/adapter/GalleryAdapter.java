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
import com.example.thequizapp.model.Entry;

import java.util.List;

/**
 * The GalleryAdapter class is responsible for inserting ListView with image items
 */
public class GalleryAdapter extends ArrayAdapter<Entry> {
    private Context aContext;
    private int aResource;

    public GalleryAdapter(@NonNull Context context, int resource, List<Entry> entries) {
        super(context, resource, entries);
        this.aContext = context;
        this.aResource = resource;
    }

    /**
     * Returns a View representing an entity in the ListView
     * @param position The position of the item within the adapter's data set of the item whose view
     *        we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *        is non-null and of an appropriate type before using. If it is not possible to convert
     *        this view to display the correct data, this method can create a new view.
     *        Heterogeneous lists can specify their number of view types, so that this View is
     *        always of the right type (see {@link #getViewTypeCount()} and
     *        {@link #getItemViewType(int)}).
     * @param parent The parent that this view will eventually be attached to
     * @return The View representing the item at the specified position
     */
    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        // Obtain the LayoutInflater from the provided Context
        LayoutInflater layoutInflater = LayoutInflater.from(aContext);

        // Get the Entry object at the specified position
        Entry entry = getItem(position);

        // If convertView is null, inflate the layout for the ListView item
        if (convertView == null) {
            convertView = layoutInflater.inflate(aResource, parent, false);
        }

        // Get references to ImageView and TextView in the inflated layout
        ImageView imageView = convertView.findViewById(R.id.image);
        TextView textView = convertView.findViewById(R.id.textView);

        // Set the image and text for the current item in the ListView
        if (entry != null) {
            imageView.setImageURI(entry.getImage());
            textView.setText(entry.getName());
        }

        // Return the populated view
        return convertView;
    }
}
