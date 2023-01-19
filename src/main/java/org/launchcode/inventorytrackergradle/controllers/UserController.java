package org.launchcode.inventorytrackergradle.controllers;
import org.launchcode.inventorytrackergradle.models.data.UserRepository;
import org.launchcode.inventorytrackergradle.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("populate")
    String populateDatabase(){

        User user = new User("NewUser1", "mail@email.com", "1234567", "1234", "1234");
        userRepository.save(user);
        User user2 = new User("NewUser2", "mail2@email.com", "89101112", "5678","5678");
        userRepository.save(user2);
        User user3 = new User("NewUser3", "mail3@email.com", "13141516", "9101", "9101");
        userRepository.save(user3);
        return "ok";
    }

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
}
