package org.scd.repository;

import org.scd.model.UserLocation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface UserLocationRepository extends CrudRepository<UserLocation,Long> {

    UserLocation save(UserLocation userLocation);

    @Query(value="SELECT * FROM locations WHERE user_id=?1 AND creation_date>=?2 AND creation_date<=?3",nativeQuery = true)
    List<UserLocation> customQuery(final Long userId,final Date startDate,final Date endDate);

    UserLocation getById(final Long id);

    void deleteById(final Long id);

}
