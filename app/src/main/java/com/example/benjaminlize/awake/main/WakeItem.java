package com.example.benjaminlize.awake.main;

/**
 * Created by benjamin.lize on 21/05/2016.
 */
public class WakeItem {
    String title;
    int description;
    String image;
    String detailURL;
    String profileURL;

    public WakeItem(String title, int description, String image, String url) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.detailURL = url;

    }


    public String getDetailURL() {
        return detailURL;
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
