package org.scd.service;

import org.scd.config.exception.BusinessException;
import org.scd.model.UserLocation;
import org.scd.model.dto.UserLocationDTO;
import org.scd.model.dto.UserLocationFilterDTO;

import java.util.List;

public interface UserLocationService {

    UserLocation update(UserLocation userLocation,final Long id);

    UserLocation addLocation(final UserLocationDTO userLocationDTO);

    Iterable<UserLocation> getAllLocations();

    UserLocation getLocationById(Long id);

    void deleteById(Long id);

    List<UserLocation> getLocationsBetweenDates(UserLocationFilterDTO userLocationFilterDTO) throws BusinessException;
}
