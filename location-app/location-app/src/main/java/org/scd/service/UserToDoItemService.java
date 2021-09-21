package org.scd.service;

import org.scd.model.UserLocation;
import org.scd.model.UserToDoItem;
import org.scd.model.dto.UserToDoItemDTO;

import java.util.List;

public interface UserToDoItemService {

    UserToDoItem create(UserToDoItemDTO userToDoItemDTO);

    void deleteById(long id);

    Iterable<UserToDoItem> getAll();

    List<UserToDoItem> getAllForOneUser(long id);

    UserToDoItem update(UserToDoItem userToDoItem, final Long id);
}
