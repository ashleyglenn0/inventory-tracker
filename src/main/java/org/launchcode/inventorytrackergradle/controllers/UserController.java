package org.launchcode.inventorytrackergradle.controllers;
import org.launchcode.inventorytrackergradle.models.data.UserRepository;
import org.launchcode.inventorytrackergradle.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User userToBeAdded = new User(user.getUsername(), user.getEmail(), user.getPhoneNumber(),
                encoder.encode(user.getPassword()));
        userRepository.save(userToBeAdded);
    }

    @PostMapping("authenticate")
    public boolean authenticate (@RequestBody User user) {

        Optional<User> userData = userRepository.findByUsername(user.getUsername());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if (userData.isPresent()) {
            User userInfo = userData.get();
            if (encoder.matches(user.getPassword(), userInfo.getPassword())) {
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
    @GetMapping("id/{id}")
    public Optional <User> findById (@PathVariable int id){

        return userRepository.findById(id);

    }


    @DeleteMapping("{id}")
    void deleteUser (@PathVariable int id){
        userRepository.deleteById(id);
    }

    @GetMapping("check/{username}")
    public boolean checkForDuplicateUsername(@PathVariable String username){
        Iterable <User> users = getUsers();
        for(User user : users){
            if(username.equalsIgnoreCase(user.getUsername())){
                return false;
            }
            }
        return true;
        }
    }

