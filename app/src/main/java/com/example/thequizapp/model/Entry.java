package com.example.thequizapp.model;

import android.net.Uri;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


import java.util.Objects;

/**
 * Represents an item/entry in the gallery, an image and a name
 */
@Entity(tableName = "entries")
public class Entry {
    @ColumnInfo(name = "entry_id")
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "image_string")
    private String imageStr;
    @ColumnInfo(name = "name_string")
    private String name;
    @Ignore
    public Entry() {
    }


    public Entry(String imageStr, String name) {
        this.name = name;
        this.imageStr = imageStr;
        this.id = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to get URI of the Image
     * @return The URI of the Image
     */
    public Uri getImage() {
        return Uri.parse(imageStr);
    }

    public String getImageStr() {
        return imageStr;
    }

    public void setImageStr(String imageStr) {
        this.imageStr = imageStr;
    }

    /**
     * Method to set URI of the image
     * @param image The URI of the image
     */
    public void setImage(String image) {
        this.imageStr = image.toString();

    }

    /**
     * Compares this ImageItem to the object. The result is true if argument is not null
     * and is an ImageItem object with the same image URI and name as this object.
     * @param o The object to compare this ImageItem
     * @return true if the given object is an ImageItem eaual to this image item, false if something else
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return imageStr == entry.imageStr &&
                Objects.equals(name, entry.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageStr, name);
    }


    /**
     *
     * @return A string of the ImageItem
     */
    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", image=" + imageStr +
                ", name='" + name + '\'' +
                '}';
    }
}
