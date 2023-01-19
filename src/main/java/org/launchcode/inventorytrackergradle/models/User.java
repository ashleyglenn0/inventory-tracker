package org.launchcode.inventorytrackergradle.models;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.*;


@Entity
public class User extends AbstractEntity {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @NotNull
    @NotBlank(message="User name is required")
    @Size(min=5, max=20, message= "Invalid username! It must be between 5 and 20 characters.")
    private String username;

    @Email(message="Invalid email. Try again!")
    @NotNull
    @NotBlank
    private String email;

    //Is there a validation annotation for phone numbers?
    @NotBlank
    @NotNull
    @Size(min=10, max=10)
    private String phoneNumber;

    @NotNull
    private String password;

    @NotNull
    private String confirmPassword;



    public User() {}
    // Need to work on how I can make sure that the user can enter either email or username
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public User(String username, String email, String phoneNumber, String password, String confirmPassword) {
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.confirmPassword = confirmPassword;


    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}

