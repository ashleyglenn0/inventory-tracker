package org.launchcode.inventorytrackergradle.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Item extends AbstractEntity{

        @ManyToOne
        private Manufacturer manufacturer;

        private String description;

        private int numberInInventory;

        private int numberMinimumToKeepOnHand;

        public Item() {
        }

    public Item(Manufacturer manufacturer, String description, int numberInInventory, int numberMinimumToKeepOnHand){
        super();
        this.manufacturer = manufacturer;
        this.description = description;
        this.numberInInventory = numberInInventory;
        this.numberMinimumToKeepOnHand = numberMinimumToKeepOnHand;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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
}
