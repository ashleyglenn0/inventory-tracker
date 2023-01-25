package org.launchcode.inventorytrackergradle.controllers;
import org.launchcode.inventorytrackergradle.models.data.UserRepository;
import org.launchcode.inventorytrackergradle.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public Iterable<User> getUsers (){
        return  userRepository.findAll();
    }

    @PostMapping("add")
    void addUser(@RequestBody User user) {
        User userToBeAdded = new User(user.getUsername(), user.getEmail(), user.getPhoneNumber(),
                user.getPassword(), user.getConfirmPassword());
        userRepository.save(userToBeAdded);
    }

    @PostMapping("authenticate")
    public boolean authenticate (@RequestBody User user) {

        Optional<User> userData = userRepository.findByUsername(user.getUsername());


        if (userData.isPresent()) {
            User userInfo = userData.get();
            if (user.getPassword().matches(userInfo.getPassword())) {
                System.out.println("it's a match!");
                return true;
            } else {
                System.out.println("not a match");
                return false;
            }
        } else {
            System.out.println("no userdata present");
            return false;
        }

    }
}
