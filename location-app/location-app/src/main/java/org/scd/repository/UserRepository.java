package org.scd.repository;

import org.scd.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(final String email);

    User save(User user);

}