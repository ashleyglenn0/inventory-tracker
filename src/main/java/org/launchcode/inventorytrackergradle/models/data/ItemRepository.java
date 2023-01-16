package org.launchcode.inventorytrackergradle.models.data;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.launchcode.inventorytrackergradle.models.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {



}