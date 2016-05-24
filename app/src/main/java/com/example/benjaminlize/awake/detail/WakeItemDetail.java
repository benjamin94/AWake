package com.example.benjaminlize.awake.detail;

/**
 * Created by benjamin.lize on 21/05/2016.
 */
public class WakeItemDetail {

    String title;
    String description;
    String imageUrl;
    String footprint;
    String urlWebpage;

    public WakeItemDetail(String title, String description, String imageUrl, String domain, String urlWebpage) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.footprint = domain;
        this.urlWebpage = urlWebpage;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getFootprint() {
        return footprint;
    }

    public String getUrlWebpage() {
        return urlWebpage;
    }
}
