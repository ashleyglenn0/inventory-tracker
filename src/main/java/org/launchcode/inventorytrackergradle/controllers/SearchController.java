package org.launchcode.inventorytrackergradle.controllers;

import org.launchcode.inventorytrackergradle.models.Item;
import org.launchcode.inventorytrackergradle.models.ItemData;
import org.launchcode.inventorytrackergradle.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping
public class SearchController {
    @Autowired
    private ItemRepository itemRepository;

    @PostMapping("results")
    public Iterable<Item> displaySearchResults(@RequestParam String searchType, @RequestParam String searchTerm){
        Iterable<Item> items;
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
            items = itemRepository.findAll();
        } else {
            items = ItemData.findByColumnAndValue(searchType, searchTerm, itemRepository.findAll());
        }


        return items;
    }
}
