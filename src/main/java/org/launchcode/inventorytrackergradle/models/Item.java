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

    private int numberInInventory;

    private int numberMinimumToKeepOnHand;

    public Item() {
    }

    public Item(Manufacturer manufacturer, String name, String description, int numberInInventory, int numberMinimumToKeepOnHand){
        super();
        this.manufacturer = manufacturer;
        this.name = name;
        this.description = description;
        this.numberInInventory = numberInInventory;
        this.numberMinimumToKeepOnHand = numberMinimumToKeepOnHand;
    }

    public boolean aboveMinAmount(){
      if (this.numberInInventory >= this.numberMinimumToKeepOnHand){
          return true;
      } else {
          return false;
      }
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
