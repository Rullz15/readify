package com.fachrulziyyan.readify;

public class Novel {
    private String title;
    private String subtitle;
    private String price;
    private String rating;
    private int imageResId;
    private String description;

    public Novel(String title, String subtitle, String price, String rating, int imageResId, String description) {
        this.title = title;
        this.subtitle = subtitle;
        this.price = price;
        this.rating = rating;
        this.imageResId = imageResId;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getPrice() {
        return price;
    }

    public String getRating() {
        return rating;
    }

    public int getImageResId() {
        return imageResId;
    }
    public String getDescription(){ return description;}
}

