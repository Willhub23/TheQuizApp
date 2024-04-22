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
     * @return
     */

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(aContext);
        Entry entry = getItem(position);
        if (convertView == null) {
            convertView = layoutInflater.inflate(aResource, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.image);
        imageView.setImageURI(entry.getImage());

        TextView textView = convertView.findViewById(R.id.textView);
        textView.setText(entry.getName());

        return convertView;
    }
}