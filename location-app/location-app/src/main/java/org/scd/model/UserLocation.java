package org.scd.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "LOCATIONS")
public class UserLocation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "LATITUDE", nullable = false, length = 45)
    private String latitude;

    @Column(name = "LONGITUDE", nullable = false, length = 45)
    private String longitude;

    @Column(name = "CREATION_DATE", nullable = false, length = 45)
    private Date creationDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    @JsonIgnore
    private User user;

    public UserLocation() {
    }

    public UserLocation(String latitude, String longitude, Date date, User user) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.creationDate = date;
        this.user=user;
    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
