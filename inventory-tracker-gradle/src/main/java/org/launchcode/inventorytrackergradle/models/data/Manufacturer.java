package org.launchcode.inventorytrackergradle.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Manufacturer extends AbstractEntity {

    private String phoneNumber;

    private String emailAddress;

    @OneToMany
    @JoinColumn(name = "manufacturer_id")
    private final List<Item> items = new ArrayList<>();

    public Manufacturer() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<Item> getItems() {
        return items;
    }
}