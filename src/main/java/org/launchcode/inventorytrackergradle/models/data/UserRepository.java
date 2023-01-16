package org.launchcode.inventorytrackergradle.models.data;

import org.launchcode.inventorytrackergradle.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByUsername(String username);

}