package com.example.thequizapp.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ImageItemList {
    private List<ImageItem>  imageList;

    public ImageItemList() {
        this.imageList = new ArrayList<>();
    }

    public List<ImageItem> getImageList() {
        return imageList;
    }

    public void setImageList(List<ImageItem> imageList) {
        this.imageList = imageList;
    }

    public void add(ImageItem newEntry) {
        imageList.add(newEntry);
        sort();
    }

    public void remove(ImageItem entry) {
        imageList.remove(entry);
    }

    public ImageItem getRandomImageItem() {
        List<ImageItem> copy = imageList;
        ImageItem prev = copy.get(0);

        while(copy.get(0).equals(prev)) {
            Collections.shuffle(copy);
        }

        return copy.get(0);
    }

    public void sort() {
        imageList.sort(Comparator.comparing(ImageItem::getName));
    }

    public List<String> getThreeRandomAnswers(ImageItem correctName) {
        List<String> answers = new ArrayList<String>();
        List<ImageItem> copy = imageList;

        answers.add(correctName.getName());

        Collections.shuffle(copy);

        ImageItem wrongName1, wrongName2;

        if (copy.get(0).equals(correctName)) {
            wrongName1 = copy.get(1);
            wrongName2 = copy.get(2);

        } else {
            wrongName1 = copy.get(0);
            if(copy.get(1).equals(correctName)) {
                wrongName2 = copy.get(2);
            } else {
                wrongName2 = copy.get(1);
            }
        }

        answers.add(wrongName1.getName());
        answers.add(wrongName2.getName());

        return answers;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("List: { \n");
        for(ImageItem o : imageList) {
            str.append(o.getImage()).append(" ").append(o.getName()).append("\n");
        }
        str.append("}");
        return str.toString();
    }
}
