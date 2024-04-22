
package com.example.thequizapp.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Represents a list of ImageItem objects
 */
public class EntryList {

    private Entry correct;
    private List<Entry>  imageList;

    /**
     * Constructs a new ImageItemList object with an empty list of ImageItem objects
     */
    public EntryList() {
        this.correct = null;
        this.imageList = new ArrayList<Entry>();
    }

    /**
     * Method to get the list of ImageItem objects
     * @return the list of ImageItem objects
     */
    public List<Entry> getImageList() {
        return imageList;
    }

    /**
     * Sets the list of ImageItem objects
     * @param imageList
     */
    public void setImageList(List<Entry> imageList) {
        this.imageList = imageList;
    }

    /**
     * Adds a new ImageItem object to the list and sorts the list alphabetically
     * @param newEntry The new ImageItem object to add
     */
    public void add(Entry newEntry) {
        imageList.add(newEntry);
        sort();
    }

    /**
     * Removes the specified ImageItem object from the list
     * @param entry
     */
    public void remove(Entry entry) {
        imageList.remove(entry);
    }

    /**
     * Get a random ImageItem object from the list
     * @return A random ImageItem object
     */
    public Entry getRandomImageItem() {
        List<Entry> copy = imageList;
        Entry prev = copy.get(0);

        while(copy.get(0).equals(prev)) {
            Collections.shuffle(copy);
        }

        return copy.get(0);
    }

    /**
     * Sorts the list of ImageItem objects alphabetically by name
     */
    public void sort() {
        imageList.sort(Comparator.comparing(Entry::getName));
    }

    /**
     * Generates a list of three random answer options, including the correct one.
     * @param correctName the correct name to include
     * @return A list of three answer options
     */
    public List<String> getThreeRandomAnswers(Entry correctName) {
        List<String> answers = new ArrayList<String>();
        List<Entry> copy = imageList;

        answers.add(correctName.getName());

        Collections.shuffle(copy);

        Entry wrongName1, wrongName2;

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

        Collections.shuffle(answers);

        return answers;
    }

    public Entry getCorrect() {
        return correct;
    }
    /**
     *
     * @return A string representation of the ImageItemList
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("List: { \n");
        for(Entry o : imageList) {
            str.append(o.getImage()).append(" ").append(o.getName()).append("\n");
        }
        str.append("}");
        return str.toString();
    }
}
