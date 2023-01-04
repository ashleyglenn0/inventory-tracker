package org.launchcode.inventorytrackergradle.models;

@Entity
public class Item extends AbstractEntity {

    @ManyToOne
    private Manufacturer manufacturer;

    private int numberOnHand;

    private int minimumAmount;

    private String description;

    public Item() {
    }

    public Item(Manufacturer aManufacturer, int numberOnHand, int minimumAmount, String description) {
        super();
        this.manufacturer = aManufacturer;
        this.numberOnHand = numberOnHand;
        this.minimumAmount = minimumAmount;
        this.description = description;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getNumberOnHand() {
        return numberOnHand;
    }

    public void setNumberOnHand(int numberOnHand) {
        this.numberOnHand = numberOnHand;
    }

    public int getMinimumAmount() {
        return minimumAmount;
    }

    public void setMinimumAmount(int minimumAmount) {
        this.minimumAmount = minimumAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}