package com.sut.ood.onlinefoodbackend.Model.Restaurant;

import jakarta.persistence.*;

import java.util.ArrayList;

@Table(name = "MENU")
@Entity
public class Menu {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "RESTAURANT_ID")
    private Long restaurantID;
    @Column(name = "NAME")
    private String name;
    @Transient
    private ArrayList<MenuItem> items;

    public Menu() {
    }

    public Menu(String name) {
        this.name = name;
    }

    public Menu(Long restaurantID, String name) {
        this.restaurantID = restaurantID;
        this.name = name;
    }

    public Menu(Long id, Long restaurantID, String name) {
        this.id = id;
        this.restaurantID = restaurantID;
        this.name = name;
    }

    public Menu(Long id, Long restaurantID, String name, ArrayList<MenuItem> items) {
        this.id = id;
        this.restaurantID = restaurantID;
        this.name = name;
        this.items = items;
    }

    public Long getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(Long restaurantID) {
        this.restaurantID = restaurantID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItems(ArrayList<MenuItem> items) {
        this.items = items;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<MenuItem> getItems() {
        return this.items;
    }

    public void addMenuItem(String name, String description, float price) {
        this.items.add(new MenuItem(price, description, name));
    }

    public void addMenuItem(MenuItem item) {
        this.items.add(item);
    }

    private MenuItem findItem(String name) {
        for (MenuItem item : this.items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public boolean removeMenuItem(String name) {
        MenuItem item = findItem(name);
        if (item != null) {
            this.items.remove(item);
            return true;
        } else {
            System.out.println("Item " + name + " doesn't exist!");
            return false;
        }
    }

    public boolean changeItemPrice(String name, float newPrice) {
        if (newPrice <= 0) {
            System.out.println("Price must be positive");
            return false;
        }
        MenuItem item = findItem(name);
        if (item != null) {
            item.setPrice(newPrice);
            return true;
        } else {
            System.out.println("Item " + name + " doesn't exist!");
            return false;
        }
    }

    public Menu copy(String name) {
        Menu newMenu = new Menu(name);
        for (MenuItem item : this.items) {
            newMenu.addMenuItem(item);
        }
        return newMenu;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
