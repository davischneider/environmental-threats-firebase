package com.example.environmentalthreatsfirebase;

public class EnvironmentalThreat {
    private long id;
    private String address;
    private String date;
    private String description;
    private String image;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "EnvironmentalThreat{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
