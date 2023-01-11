package org.launchcode.inventorytrackergradle.controllers;

import org.launchcode.inventorytrackergradle.models.Item;
import org.launchcode.inventorytrackergradle.models.ItemData;
import org.launchcode.inventorytrackergradle.repositories.ItemRepository;
import org.launchcode.inventorytrackergradle.repositories.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "list")
public class ListController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @RequestMapping(value = "items")
    public Iterable<Item> listJobsByColumnAndValue(@RequestParam String column, @RequestParam String value) {
        Iterable<Item> items;
        if (column.toLowerCase().equals("all")) {
            items = itemRepository.findAll();
        } else {
            items = ItemData.findByColumnAndValue(column, value, itemRepository.findAll());
        }
            return items;
        }
}

