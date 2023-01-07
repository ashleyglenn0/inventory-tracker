package org.launchcode.inventorytrackergradle.models.data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Item extends AbstractEntity{

        @ManyToOne
        private Manufacturer manufacturer;

        private String description;

        private double numberInInventory;

        private double numberMinimumToKeepOnHand;

        public Item() {
        }

    public Item(Manufacturer manufacturer, String description, double numberInInventory, double numberMinimumToKeepOnHand){
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

    public double getNumberInInventory() {
        return numberInInventory;
    }

    public void setNumberInInventory(double numberInInventory) {
        this.numberInInventory = numberInInventory;
    }

    public double getNumberMinimumToKeepOnHand() {
        return numberMinimumToKeepOnHand;
    }

    public void setNumberMinimumToKeepOnHand(double numberMinimumToKeepOnHand) {
        this.numberMinimumToKeepOnHand = numberMinimumToKeepOnHand;
    }
}
