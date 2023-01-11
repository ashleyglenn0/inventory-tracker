package org.launchcode.inventorytrackergradle.controllers;

import org.launchcode.inventorytrackergradle.models.Item;
import org.launchcode.inventorytrackergradle.models.ItemData;
import org.launchcode.inventorytrackergradle.repositories.ItemRepository;
import org.launchcode.inventorytrackergradle.repositories.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping(value = "list")
public class ListController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController () {

        columnChoices.put("all", "All");
        columnChoices.put("manufacturer", "Manufacturer");

    }

    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        return "list";
    }

    @RequestMapping(value = "items")
    public String listJobsByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
        Iterable<Item> items;
        if (column.toLowerCase().equals("all")){
            items = itemRepository.findAll();
            model.addAttribute("title", "All Items");
        } else {
            items = ItemData.findByColumnAndValue(column, value, itemRepository.findAll());
            model.addAttribute("title", "Items with " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("items", items);

        return "list-jobs";
    }

}
