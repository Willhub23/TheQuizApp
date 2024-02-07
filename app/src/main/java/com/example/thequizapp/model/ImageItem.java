package com.example.thequizapp.model;

import android.net.Uri;

import java.util.Objects;

public class ImageItem {
    private Uri image;
    private String name;

    public ImageItem(Uri image, String name) {
        this.name = name;
        this.image = image;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Uri getImage() {
        return image;
    }
    public void setImage(Uri image) {
        this.image = image;

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageItem imageItem = (ImageItem) o;
        return Objects.equals(image, imageItem.image) && Objects.equals(name, imageItem.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(image,name);
    }

    @Override
    public String toString() {
        return "ImageItem{" +
                "image=" + image +
                ", name= '" + name + '\'' +
                '}';
    }
}
