package org.scd.service;

import org.scd.model.UserLocation;
import org.scd.model.dto.UserLocationAdminDTO;
import org.scd.model.dto.UserLocationDTO;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserLocationService {

    UserLocation update(UserLocation userLocation,final Long id);

    UserLocationDTO addLocation(final UserLocationDTO userLocationDTO);

}
