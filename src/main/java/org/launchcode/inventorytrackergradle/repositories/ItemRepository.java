package org.launchcode.inventorytrackergradle.repositories;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.launchcode.inventorytrackergradle.models.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {
}