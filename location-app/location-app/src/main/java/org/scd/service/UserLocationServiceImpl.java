package org.scd.service;


import org.scd.config.exception.BusinessException;
import org.scd.model.User;
import org.scd.model.UserLocation;
import org.scd.model.dto.UserLocationAdminDTO;
import org.scd.model.dto.UserLocationDTO;
import org.scd.repository.UserLocationRepository;
import org.scd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserLocationServiceImpl implements UserLocationService {

    @Autowired
    private UserLocationRepository locationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserLocationRepository userLocationRepository;


    public List<UserLocation> getAllLocations() {
        List<UserLocation> userLocations = new ArrayList<>();
        locationRepository.findAll().forEach(userLocations::add);
        return userLocations;
    }

    public UserLocation getLocationById(Long id) {
        return locationRepository.getById(id);
    }

    public void deleteById(Long id) {
        locationRepository.deleteById(id);
    }

    @Override
    public UserLocation update(UserLocation userLocation,Long id) {
        UserLocation userLocationUpdated = userLocationRepository.getById(id);
        if(!(userLocation.getLatitude()==null)) userLocationUpdated.setLatitude(userLocation.getLatitude());
        if(!(userLocation.getLongitude()==null)) userLocationUpdated.setLongitude(userLocation.getLongitude());
        return locationRepository.save(userLocationUpdated);
    }

    @Override
    public UserLocationDTO addLocation(UserLocationDTO userLocationDTO) {

        locationRepository.save(new UserLocation(userLocationDTO.getLatitude(), userLocationDTO.getLongitude(), userLocationDTO.getCreationDate(), userRepository.findByEmail(userLocationDTO.getEmail())));
        return null;
    }

    public List<UserLocation> getLocationsBetweenDates(UserLocationAdminDTO userLocationAdminDTO) throws BusinessException{
        if (userLocationAdminDTO.getStartDate().compareTo(userLocationAdminDTO.getEndDate()) > 0)
            throw new BusinessException(402, "End date cannot be before start date");
        return userLocationRepository.customQuery(userLocationAdminDTO.getUserId(),userLocationAdminDTO.getStartDate(),userLocationAdminDTO.getEndDate());
    }

}
