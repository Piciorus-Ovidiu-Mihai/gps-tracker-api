package org.scd.controller;

import org.scd.config.exception.BusinessException;
import org.scd.model.UserLocation;
import org.scd.model.UserToDoItem;
import org.scd.model.dto.UserLocationDTO;
import org.scd.model.dto.UserLocationFilterDTO;
import org.scd.model.dto.UserToDoItemDTO;
import org.scd.service.UserToDoItemService;
import org.scd.service.UserToDoItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController()
@RequestMapping("/todo")
public class UserToDoItemController {
    private final UserToDoItemService userToDoItemService;

    public UserToDoItemController(UserToDoItemService userToDoItemService) {
        this.userToDoItemService = userToDoItemService;
    }

    @DeleteMapping(path = "/delete/{toDoItemId}")
    public void deleteToDoItem(@PathVariable("toDoItemId") Long toDoItemId) {
        userToDoItemService.deleteById(toDoItemId);
    }

    @GetMapping(path = "/to-do-list")
    public Iterable<UserToDoItem> getAll() {
        return userToDoItemService.getAll();
    }

    @GetMapping(path = "/get/{toDoItemId}")
    public List<UserToDoItem> getAllForOneUser(@PathVariable("toDoItemId") Long toDoItemId) {
        return userToDoItemService.getAllForOneUser(toDoItemId);
    }

    @PutMapping(path = "/update/{id}")
    public UserToDoItem update(@RequestBody UserToDoItem userToDoItem, @PathVariable long id) {
        return userToDoItemService.update(userToDoItem, id);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<UserToDoItem> create(@RequestBody final UserToDoItemDTO userToDoItemDTO) {
        return ResponseEntity.ok(userToDoItemService.create(userToDoItemDTO));
    }
}
