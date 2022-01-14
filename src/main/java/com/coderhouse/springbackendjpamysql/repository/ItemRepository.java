package com.coderhouse.springbackendjpamysql.repository;

import com.coderhouse.springbackendjpamysql.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {


}
