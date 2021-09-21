package org.scd.repository;

import org.scd.model.User;
import org.scd.model.UserLocation;
import org.scd.model.UserToDoItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface UserToDoItemRepository extends CrudRepository<UserToDoItem, Long> {
    void deleteById(final Long id);

    UserToDoItem save(UserToDoItem userToDoItem);

    Iterable<UserToDoItem> findAll();

    @Query(value="SELECT * FROM TODOLIST WHERE user_id=?1",nativeQuery = true)
    List<UserToDoItem> customQuery(final Long userId);

    UserToDoItem getById(final Long id);
}
