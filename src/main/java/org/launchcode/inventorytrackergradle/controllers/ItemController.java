package org.launchcode.inventorytrackergradle.controllers;

import org.launchcode.inventorytrackergradle.models.Item;
import org.launchcode.inventorytrackergradle.models.data.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("items")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("")
    public Iterable<Item> getItems() {return itemRepository.findAll(); }

    @PostMapping("add")
    void addItem(@RequestBody Item item) {
        Item itemToBeAdded = new Item(item.getManufacturer(), item.getName(), item.getDescription(),
                item.getCategory(), item.getNumberInInventory(), item.getNumberMinimumToKeepOnHand());
        itemRepository.save(itemToBeAdded);
    }

    @GetMapping("id/{id}")
    public Optional<Item> findById (@PathVariable int id){
        return itemRepository.findById(id);
    }


    @DeleteMapping("{id}")
    void deleteItem (@PathVariable int id){
        itemRepository.deleteById(id);
    }
}