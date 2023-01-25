package org.launchcode.inventorytrackergradle.controllers;

import org.launchcode.inventorytrackergradle.models.Manufacturer;
import org.launchcode.inventorytrackergradle.models.data.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("manufacturers")
public class ManufacturerController {
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @GetMapping("")
    public Iterable<Manufacturer> getManufacturers (){
        return manufacturerRepository.findAll();
    }

    @PostMapping("add")
    void addManufacturer(@RequestBody Manufacturer manufacturer) {
        Manufacturer manufacturerToBeAdded = new Manufacturer(manufacturer.getAddress(), manufacturer.getPhoneNumber());
        manufacturerRepository.save(manufacturerToBeAdded);
    }
}