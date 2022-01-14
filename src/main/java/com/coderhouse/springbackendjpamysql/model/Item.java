package com.coderhouse.springbackendjpamysql.model;

import javax.persistence.*;

@Entity @Table(name = "items")
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String category;
    private Integer stock;

    public Item() {};
    public Item(String name, String category, Integer stock){
        this.name = name;
        this.category = category;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
