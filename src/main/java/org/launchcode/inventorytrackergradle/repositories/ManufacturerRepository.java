package org.launchcode.inventorytrackergradle.repositories;

import org.launchcode.inventorytrackergradle.models.Manufacturer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends CrudRepository<Manufacturer, Integer> {
}