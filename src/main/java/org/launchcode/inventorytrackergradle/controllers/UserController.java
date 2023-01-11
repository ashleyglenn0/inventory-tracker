package org.launchcode.inventorytrackergradle.controllers;
import main.java.org.launchcode.inventorytrackergradle.repositories.UserRepository;
import org.launchcode.inventorytrackergradle.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public Iterable<User> getUsers (){
        return  userRepository.findAll();
    }

    @PostMapping("")
    void addUser(@RequestBody User user) {
        User userToBeAdded = new User(user.getUsername(), user.getEmail(), user.getPhoneNumber(),
                user.getPwHash());
        userRepository.save(userToBeAdded);
    }
}
