package org.scd.service;

import org.scd.model.UserToDoItem;
import org.scd.model.dto.UserToDoItemDTO;
import org.scd.repository.UserRepository;
import org.scd.repository.UserToDoItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserToDoItemServiceImpl implements UserToDoItemService{
    private final UserRepository userRepository;

    private final UserToDoItemRepository userToDoItemRepository;

    public UserToDoItemServiceImpl(UserRepository userRepository, UserToDoItemRepository userToDoItemRepository) {
        this.userRepository = userRepository;
        this.userToDoItemRepository = userToDoItemRepository;
    }


    @Override
    public UserToDoItem create(UserToDoItemDTO userToDoItemDTO) {
        return userToDoItemRepository.save(new UserToDoItem(userToDoItemDTO.getName(),userToDoItemDTO.isComplete(), userRepository.findByEmail(userToDoItemDTO.getEmail())));
    }

    @Override
    public void deleteById(long id) {
        userToDoItemRepository.deleteById(id);
    }

    @Override
    public Iterable<UserToDoItem> getAll() {
        return userToDoItemRepository.findAll();
    }

    @Override
    public List<UserToDoItem> getAllForOneUser(long id) {
        return userToDoItemRepository.customQuery(id);
    }

    @Override
    public UserToDoItem update(UserToDoItem userToDoItem, Long id) {
        UserToDoItem userToDoItemUpdated = userToDoItemRepository.getById(id);
        userToDoItemUpdated.setComplete(userToDoItem.isComplete());
        return userToDoItemRepository.save(userToDoItemUpdated);
    }
}
