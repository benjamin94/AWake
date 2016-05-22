package com.example.benjaminlize.awake.pojo;

/**
 * Created by benjamin.lize on 21/05/2016.
 */
public class WakeItem {
    String title;
    int description;
    String image;

    public WakeItem(String title, int description, String image) {
        this.title = title;
        this.description = description;
        this.image = image;

    }

    public String getTitle() {
        return title;
    }

    public int getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

}
