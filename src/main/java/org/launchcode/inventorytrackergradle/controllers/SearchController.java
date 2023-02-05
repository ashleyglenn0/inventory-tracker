package org.launchcode.inventorytrackergradle.controllers;

import org.launchcode.inventorytrackergradle.models.Item;
import org.launchcode.inventorytrackergradle.models.ItemData;
import org.launchcode.inventorytrackergradle.models.Manufacturer;
import org.launchcode.inventorytrackergradle.models.data.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("search")
public class SearchController {
    @Autowired
    private ItemRepository itemRepository;

    @PostMapping("results")
    public Iterable<Item> displaySearchResults(@RequestParam String searchTerm){
        return ItemData.findByValue(searchTerm, itemRepository.findAll());
    }
}
