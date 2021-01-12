package org.scd.model.dto;


import java.util.Date;

public class UserLocationDTO {

    private String latitude;
    private String longitude;
    private Date creationDate;
    private String email;

    public UserLocationDTO(String latitude, String longitude, String email) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.creationDate = new Date();
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
