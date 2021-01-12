package org.scd.controller;


import org.scd.config.exception.BusinessException;
import org.scd.model.UserLocation;
import org.scd.model.dto.UserLocationAdminDTO;
import org.scd.model.dto.UserLocationDTO;
import org.scd.service.UserLocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.method.annotation.CsrfTokenArgumentResolver;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/locations")
public class UserLocationController {
    private final UserLocationServiceImpl locationServiceImpl;

    @Autowired
    public UserLocationController(UserLocationServiceImpl locationServiceImpl) {
        this.locationServiceImpl = locationServiceImpl;
    }

    @GetMapping(path = "/allLocations")
    public List<UserLocation> getAllLocations() {
        return locationServiceImpl.getAllLocations();
    }

    @GetMapping(path = "/locations/{locationId}")
    public UserLocation getLocation(@PathVariable("locationId") Long locationId) {
        return locationServiceImpl.getLocationById(locationId);
    }

    @DeleteMapping(path = "/delete/{locationid}")
    public void deleteLocation(@PathVariable("locationid") Long locationid) {
        locationServiceImpl.deleteById(locationid);
    }

    @PutMapping(path = "/updateLocation/{id}")
    public UserLocation updateLocation(@RequestBody UserLocation userLocation, @PathVariable long id) {
        return locationServiceImpl.update(userLocation, id);
    }

    @PostMapping(path = "/createLocation")
    public ResponseEntity<UserLocationDTO> addLocation(@RequestBody final UserLocationDTO userLocationDTO) {
        return ResponseEntity.ok(locationServiceImpl.addLocation(userLocationDTO));
    }

    @GetMapping(path = "/getLocationById")
    public ResponseEntity<UserLocation> getLocationById(@RequestBody final UserLocation userLocation) {
        return ResponseEntity.ok(locationServiceImpl.getLocationById(userLocation.getId()));
    }

    @PostMapping(path = "/filterByStartAndEnd")
    public List<UserLocation> getLocationByDates(@RequestBody UserLocationAdminDTO userLocationAdminDTO) throws BusinessException {
        return locationServiceImpl.getLocationsBetweenDates(userLocationAdminDTO);
    }

}
