package org.launchcode.inventorytrackergradle.models.data;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.launchcode.inventorytrackergradle.models.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {
    List<Item> findByBelowMinAmountTrue();
}