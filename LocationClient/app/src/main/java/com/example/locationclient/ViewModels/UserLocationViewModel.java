package com.example.locationclient.ViewModels;

public class UserLocationViewModel {
    private String email;
    private String longitude;
    private String latitude;

    public UserLocationViewModel(String email, String longitude, String latitude) {
        this.email = email;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
