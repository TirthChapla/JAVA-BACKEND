package com.Spring_JPA.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


//✅ This shows Entity(Table) in the DB

@Entity
@Table(name="products")
public class Product
{
// ✅ Mapping of Object


    @Id                            //✅ PRIMARY KEY
    @Column(name = "product_id")
    private int id;

    @Column(name="title")
    private String name;

    private boolean live;

    //✅ Getter n Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }
}
