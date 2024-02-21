package com.example.thequizapp.model;

import android.net.Uri;

import java.util.Objects;

/**
 * Represents an item/entry in the gallery, an image and a name
 */

public class Entry {
    private Uri image;
    private String name;

    /**
     * Constructor for ImageItem class
     * @param image The URI of the image
     * @param name The name associated with the image
     */
    public Entry(Uri image, String name) {
        this.name = name;
        this.image = image;
    }

    /**
     * Method to get the name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Method to set the name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to get URI of the Image
     * @return The URI of the Image
     */
    public Uri getImage() {
        return image;
    }

    /**
     * Method to set URI of the image
     * @param image The URI of the image
     */
    public void setImage(Uri image) {
        this.image = image;

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
        return Objects.equals(image, entry.image) && Objects.equals(name, entry.name);
    }
    /**
     *
     * @return A string of the ImageItem
     */
    @Override
    public String toString() {
        return "ImageItem{" +
                "image=" + image +
                ", name= '" + name + '\'' +
                '}';
    }
}
