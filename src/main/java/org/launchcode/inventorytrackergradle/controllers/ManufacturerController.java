package org.launchcode.inventorytrackergradle.controllers;

import org.launchcode.inventorytrackergradle.models.Item;
import org.launchcode.inventorytrackergradle.models.Manufacturer;
import org.launchcode.inventorytrackergradle.models.data.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
        Manufacturer manufacturerToBeAdded = new Manufacturer(manufacturer.getName(), manufacturer.getAddress(), manufacturer.getPhoneNumber());
        manufacturerRepository.save(manufacturerToBeAdded);
    }
    @GetMapping("id/{id}")
    public Optional<Manufacturer> findById (@PathVariable int id){

        return manufacturerRepository.findById(id);

    }


    @DeleteMapping("{id}")
    void deleteUser (@PathVariable int id){
        manufacturerRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    Manufacturer replaceManufacturer(@RequestBody Manufacturer newManufacturer, @PathVariable Integer id){
        Optional<Manufacturer> manufacturerToReplace = manufacturerRepository.findById(id);
        if (manufacturerToReplace.isPresent()){
            Manufacturer manufacturerData =  manufacturerToReplace.get();
            manufacturerData.setName(newManufacturer.getName());
            manufacturerData.setAddress(newManufacturer.getAddress());
            manufacturerData.setPhoneNumber(newManufacturer.getPhoneNumber());
            return manufacturerRepository.save(manufacturerData);
        } else {
            return manufacturerRepository.save(newManufacturer); //may need to update this line - 500 error occurs if invalid id is passed
        }
    }
}