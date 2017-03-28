package com.example.adiputra.assyst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class List {
    private int id;
    private String lokasi, latitude, longitude, message, radius;

//    public List(int ID, String LOCATION, String LATITUDE, String LONGITUDE, String RADIUS, String MESSAGE) {
//    }
    public List(String lokasi, String latitude, String longitude, String radius, String message) {
        //this.id = id;
        this.lokasi = lokasi;
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }
}