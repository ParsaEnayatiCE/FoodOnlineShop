package com.sut.ood.onlinefoodbackend.Model.Restaurant;

import jakarta.persistence.*;

@Table(name = "MENU_ITEM")
@Entity
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "PRICE")
    private float price;


    public MenuItem() {
    }

    public MenuItem(String name) {
        this.name = name;
    }

    public MenuItem(Long id, String name, String description, float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public MenuItem(float price, String description, String name) {
        setPrice(price);
        this.description = description;
        this.name = name;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    public void setPrice(float newPrice) {
        if (newPrice > 0) {
            this.price = newPrice;
        }
    }

    public String getName() {
        return this.name;
    }

    public float getPrice() {
        return price;
    }

    public String getDescription() {
        return this.description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
