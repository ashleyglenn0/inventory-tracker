package org.launchcode.inventorytrackergradle.models.data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Manufacturer extends AbstractEntity{

    private String address;

    private String phoneNumber;

    @OneToMany
    @JoinColumn(name = "manufacturer_id")
    private final List<Item> items = new ArrayList<>();

    public Manufacturer() {
    }

    public Manufacturer(String address, String phoneNumber) {
        super();
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Item> getItems() {
        return items;
    }
}
