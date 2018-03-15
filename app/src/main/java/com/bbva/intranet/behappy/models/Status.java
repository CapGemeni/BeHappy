package com.bbva.intranet.behappy.models;

import java.io.Serializable;

public class Status implements Serializable{

    private String title;
    private String subtitle;
    private String image;
    private String imageSelected;
    private String imageDescription;
    private String description;
    private String color;

    private int imageResId;
    private int btnResId;
    private int headerResIdOff;
    private int headerResIdOn;
    private int bgColorResId;
    private int titleResId;
    private int descriptionResId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageSelected() {
        return imageSelected;
    }

    public void setImageSelected(String imageSelected) {
        this.imageSelected = imageSelected;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public int getBtnResId() {
        return btnResId;
    }

    public void setBtnResId(int btnResId) {
        this.btnResId = btnResId;
    }

    public int getHeaderResIdOff() {
        return headerResIdOff;
    }

    public void setHeaderResIdOff(int headerResIdOff) {
        this.headerResIdOff = headerResIdOff;
    }

    public int getHeaderResIdOn() {
        return headerResIdOn;
    }

    public void setHeaderResIdOn(int headerResIdOn) {
        this.headerResIdOn = headerResIdOn;
    }

    public int getBgColorResId() {
        return bgColorResId;
    }

    public void setBgColorResId(int bgColorResId) {
        this.bgColorResId = bgColorResId;
    }

    public int getTitleResId() {
        return titleResId;
    }

    public void setTitleResId(int titleResId) {
        this.titleResId = titleResId;
    }

    public int getDescriptionResId() {
        return descriptionResId;
    }

    public void setDescriptionResId(int descriptionResId) {
        this.descriptionResId = descriptionResId;
    }
}
