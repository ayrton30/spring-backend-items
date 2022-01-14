package com.coderhouse.springbackendjpamysql.service;

import com.coderhouse.springbackendjpamysql.handler.IdNotFoundException;
import com.coderhouse.springbackendjpamysql.model.Item;
import com.coderhouse.springbackendjpamysql.repository.ItemRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    Logger logger = LogManager.getLogger(ItemService.class);
    @Autowired
    private ItemRepository repository;

    //operaciones del CRUD: Select, Insert, Update, Delete
    public Item selectItem(Long id) throws IdNotFoundException {
        if(repository.existsById(id)){
            logger.info("selectItem(Long id)");
            return repository.findById(id).get();
        }
        else{
            throw new IdNotFoundException();
        }
    }

    public Iterable<Item> selectItems(){
        logger.info("selectItems()");
        return repository.findAll();
    }

    public Item insertItem(Item newItem){
        logger.info("insertItem(Item newItem)");
        return repository.save(newItem);
    }

    public Item updateItem(Long id, Item newItem) throws IdNotFoundException {
        if(repository.existsById(id)){
            logger.info("updateItem(Long id, Item newItem)");
            newItem.setId(id);
            return repository.save(newItem);
        }
        else{
            throw new IdNotFoundException();
        }
    }

    public void deleteItem(Long id) throws IdNotFoundException {
        if(repository.existsById(id)){
            logger.info("deleteItem(Long id)");
            repository.deleteById(id);
        }
        else{
            throw new IdNotFoundException();
        }
    }

}
