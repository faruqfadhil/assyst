package com.example.adiputra.assyst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class List {
    private int id;
    private String lokasi, latitude, longitude, message;

    public List() {
    }

    public List(int id, String lokasi, String latitude, String longitude, String message) {
        this.id = id;
        this.lokasi = lokasi;
        this.latitude = latitude;
        this.longitude = longitude;
        this.message = message;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
}