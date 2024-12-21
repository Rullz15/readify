package com.fachrulziyyan.readify;

public class Majalah {
    private String title;
    private String subtitle;
    private String price;
    private String rating;
    private int imageResId;

    public Majalah(String title, String subtitle, String price, String rating, int imageResId) {
        this.title = title;
        this.subtitle = subtitle;
        this.price = price;
        this.rating = rating;
        this.imageResId = imageResId;
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
}

