package org.scd.controller;


import org.scd.config.exception.BusinessException;
import org.scd.model.UserLocation;
import org.scd.model.dto.UserLocationFilterDTO;
import org.scd.model.dto.UserLocationDTO;
import org.scd.service.UserLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController()
@RequestMapping("/locations")
public class UserLocationController {

    private final UserLocationService userLocationService;

    public UserLocationController(UserLocationService userLocationService) {
        this.userLocationService = userLocationService;
    }

    @GetMapping(path = "/all-locations")
    public Iterable<UserLocation> getAllLocations() {
        return userLocationService.getAllLocations();
    }

    @GetMapping(path = "/locations/{locationId}")
    public UserLocation getLocation(@PathVariable("locationId") Long locationId) {
        return userLocationService.getLocationById(locationId);
    }

    @DeleteMapping(path = "/delete/{locationid}")
    public void deleteLocation(@PathVariable("locationid") Long locationid) {
        userLocationService.deleteById(locationid);
    }

    @PutMapping(path = "/updateLocation/{id}")
    public UserLocation updateLocation(@RequestBody UserLocation userLocation, @PathVariable long id) {
        return userLocationService.update(userLocation, id);
    }

    @PostMapping(path = "/createLocation")
    public ResponseEntity<UserLocation> addLocation(@RequestBody final UserLocationDTO userLocationDTO) {
        return ResponseEntity.ok(userLocationService.addLocation(userLocationDTO));
    }

    @GetMapping(path = "/getLocationById")
    public ResponseEntity<UserLocation> getLocationById(@RequestBody final UserLocation userLocation) {
        return ResponseEntity.ok(userLocationService.getLocationById(userLocation.getId()));
    }

    @PostMapping(path = "/filterByStartAndEnd")
    public List<UserLocation> getLocationByDates(@RequestBody UserLocationFilterDTO userLocationFilterDTO) throws BusinessException {
        return userLocationService.getLocationsBetweenDates(userLocationFilterDTO);
    }

}
