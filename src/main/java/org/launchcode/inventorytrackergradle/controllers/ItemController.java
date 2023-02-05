package org.launchcode.inventorytrackergradle.controllers;

import org.launchcode.inventorytrackergradle.models.Item;
import org.launchcode.inventorytrackergradle.models.Manufacturer;
import org.launchcode.inventorytrackergradle.models.data.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("items")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;
    //added this part in
    ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("")
    public Iterable<Item> getItems() {
        Iterable<Item> items = itemRepository.findAll();
        for (Item item : items) {

            Manufacturer manufacturer = item.getManufacturer();
            item.setManufacturerPhoneNumber(manufacturer.getPhoneNumber());
    }
        return items; }

    @PostMapping("add")
    void addItem(@RequestBody Item item) {
        Item itemToBeAdded = new Item(item.getManufacturer(), item.getName(), item.getDescription(),
                item.getCategory(), item.getNumberInInventory(), item.getNumberMinimumToKeepOnHand());
        itemRepository.save(itemToBeAdded);
    }

    @GetMapping("dashboard/toOrder")
    public List<Item> getItemsToOrder(){
        return itemRepository.findByBelowMinAmountTrue();
    }

    @GetMapping("id/{id}")
    public Optional<Item> findById (@PathVariable int id){
        return itemRepository.findById(id);
    }

    @DeleteMapping("{id}")
    void deleteItem (@PathVariable int id){
        itemRepository.deleteById(id);
    }

// replaces whole item, so would need to pass in all fields (aka the whole object). if we use this, consider way to have fields auto-filled  with current data so user only needs to change what they want
    @PutMapping("/{id}")
    Item replaceItem(@RequestBody Item newItem, @PathVariable Integer id){
        Optional<Item> itemToReplace = itemRepository.findById(id);
        if (itemToReplace.isPresent()){
            Item itemData =  itemToReplace.get();
            itemData.setName(newItem.getName());
            itemData.setCategory(newItem.getCategory());
            itemData.setDescription(newItem.getDescription());
            itemData.setNumberInInventory(newItem.getNumberInInventory());
            itemData.setNumberMinimumToKeepOnHand(newItem.getNumberMinimumToKeepOnHand());
            return itemRepository.save(itemData);
        } else {
            return itemRepository.save(newItem); //may need to update this line - 500 error occurs if invalid id is passed
        }
    }

    //updates number in inventory based on path variable rather than passing in an object
    @PatchMapping("/{id}/{newNumberInInventory}")
    ResponseEntity<Item> updateNumberInInventory(@PathVariable Integer id, @PathVariable int newNumberInInventory) {
        Optional<Item> itemToUpdate = itemRepository.findById(id);
        if (itemToUpdate.isPresent()){
            Item itemData =  itemToUpdate.get();
            itemData.setNumberInInventory(newNumberInInventory);
            return new ResponseEntity<Item>(itemRepository.save(itemData), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}