package org.scd.service;


import org.scd.config.exception.BusinessException;
import org.scd.mapper.UserLocationMapper;
import org.scd.model.UserLocation;
import org.scd.model.dto.UserLocationFilterDTO;
import org.scd.model.dto.UserLocationDTO;
import org.scd.repository.UserLocationRepository;
import org.scd.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLocationServiceImpl implements UserLocationService {

    private final UserRepository userRepository;

    private final UserLocationRepository userLocationRepository;

    private final UserLocationMapper userLocationMapper;

    public UserLocationServiceImpl(UserRepository userRepository, UserLocationRepository userLocationRepository, UserLocationMapper userLocationMapper) {
        this.userRepository = userRepository;
        this.userLocationRepository = userLocationRepository;
        this.userLocationMapper = userLocationMapper;
    }

    @Override
    public Iterable<UserLocation> getAllLocations() {
        return userLocationRepository.findAll();
    }

    @Override
    public UserLocation getLocationById(Long id) {
        return userLocationRepository.getById(id);
    }

    @Override
    public void deleteById(Long id) {
        userLocationRepository.deleteById(id);
    }

    @Override
    public UserLocation update(UserLocation userLocation,Long id) {
        UserLocation userLocationUpdated = userLocationRepository.getById(id);
        if(!(userLocation.getLatitude()==null)) userLocationUpdated.setLatitude(userLocation.getLatitude());
        if(!(userLocation.getLongitude()==null)) userLocationUpdated.setLongitude(userLocation.getLongitude());
        return userLocationRepository.save(userLocationUpdated);
    }

    @Override
    public UserLocation addLocation(UserLocationDTO userLocationDTO) {
        return userLocationRepository.save(new UserLocation(userLocationDTO.getLatitude(), userLocationDTO.getLongitude(), userLocationDTO.getCreationDate(), userRepository.findByEmail(userLocationDTO.getEmail())));
    }

    @Override
    public List<UserLocation> getLocationsBetweenDates(UserLocationFilterDTO userLocationFilterDTO) throws BusinessException{
        if (userLocationFilterDTO.getStartDate().compareTo(userLocationFilterDTO.getEndDate()) > 0)
            throw new BusinessException(402, "End date cannot be before start date");
        return userLocationRepository.customQuery(userLocationFilterDTO.getUserId(), userLocationFilterDTO.getStartDate(), userLocationFilterDTO.getEndDate());
    }
}
