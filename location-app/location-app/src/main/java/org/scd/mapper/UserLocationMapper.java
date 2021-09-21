package org.scd.mapper;

import org.scd.model.UserLocation;
import org.scd.model.dto.UserLocationDTO;
import org.springframework.stereotype.Component;

@Component
public class UserLocationMapper {
    public UserLocation toEntity(UserLocationDTO userLocationDTO){
        UserLocation userLocation = new UserLocation();

        userLocation.setLongitude(userLocationDTO.getLongitude());
        userLocation.setLatitude(userLocationDTO.getLatitude());

        return userLocation;
    }
}
