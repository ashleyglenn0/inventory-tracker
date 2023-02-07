package org.launchcode.inventorytrackergradle.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Item extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;
    @NotNull
    @NotBlank
    @Size(max=75)
    private String name;
    @NotNull
    @NotBlank
    @Size(max=250)
    private String description;
    private String category;
    private int numberInInventory;
    private int numberMinimumToKeepOnHand;

    private String manufacturerPhoneNumber;

    private boolean isBelowMinAmount;

    public Item() {
    }

    public Item(Manufacturer manufacturer, String name, String description, String category, int numberInInventory,
                int numberMinimumToKeepOnHand){
        super();
        this.manufacturer = manufacturer;
        this.name = name;
        this.description = description;
        this.category = category;
        this.numberInInventory = numberInInventory;
        this.numberMinimumToKeepOnHand = numberMinimumToKeepOnHand;
        this.isBelowMinAmount(numberInInventory, numberMinimumToKeepOnHand);
    }

    @JsonBackReference
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {return category;}

    public void setCategory(String category) {this.category = category;}

    public int getNumberInInventory() {
        return numberInInventory;
    }

    public void setNumberInInventory(int numberInInventory) {
        this.numberInInventory = numberInInventory;
    }

    public int getNumberMinimumToKeepOnHand() {
        return numberMinimumToKeepOnHand;
    }

    public void setNumberMinimumToKeepOnHand(int numberMinimumToKeepOnHand) {
        this.numberMinimumToKeepOnHand = numberMinimumToKeepOnHand;
    }
    public void isBelowMinAmount(int inventoryAmnt, int invMinimum) {
            this.isBelowMinAmount = (numberInInventory < numberMinimumToKeepOnHand) ? true : false;
    }

    public boolean isBelowMinAmount() {
        return isBelowMinAmount;
    }

    public void setBelowMinAmount(boolean belowMinAmount) {
        isBelowMinAmount = belowMinAmount;
    }

    public String getManufacturerPhoneNumber() {
        return manufacturerPhoneNumber;
    }

    public void setManufacturerPhoneNumber(String manufacturerPhoneNumber) {
        this.manufacturerPhoneNumber = manufacturerPhoneNumber;
    }
}
