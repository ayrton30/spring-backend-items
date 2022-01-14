package com.coderhouse.springbackendjpamysql.controller;

import com.coderhouse.springbackendjpamysql.handler.IdNotFoundException;
import com.coderhouse.springbackendjpamysql.model.Item;
import com.coderhouse.springbackendjpamysql.service.ItemService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/items")
public class Controller {

    Logger logger = LogManager.getLogger(Controller.class);
    @Autowired
    ItemService service;

    //API Rest
    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Long id) throws IdNotFoundException {
       return service.selectItem(id);
    }

    @GetMapping("")
    public Iterable<Item> getItems() {
        return service.selectItems();
    }

    @PostMapping("")
    public Item createItem(@RequestBody Item item) {
       return service.insertItem(item);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item item) throws IdNotFoundException {
        return service.updateItem(id, item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) throws IdNotFoundException {
        service.deleteItem(id);
    }

}
