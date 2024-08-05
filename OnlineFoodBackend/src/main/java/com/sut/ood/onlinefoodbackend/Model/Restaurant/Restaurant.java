package com.sut.ood.onlinefoodbackend.Model.Restaurant;

import com.sut.ood.onlinefoodbackend.Model.User.User;
import jakarta.persistence.*;

import java.util.ArrayList;

@Table(name = "RESTAURANT")
@Entity
public class Restaurant{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "USER_ID")
    private Long userID;
    @Column(name = "NAME")
    private  String name;
    @Column(name = "ADDRESS")
    private  String address;
    @Transient
    private ArrayList<Menu> menus;
    @Transient
    private User user;

    public Restaurant(Long id, Long userID, String name, String address) {
        this.id = id;
        this.userID = userID;
        this.name = name;
        this.address = address;
    }

    public Restaurant(Long userID, String name, String address) {
        this.userID = userID;
        this.name = name;
        this.address = address;
    }

    public Restaurant(Long id, Long userID, String name, String address, ArrayList<Menu> menus) {
        this.id = id;
        this.userID = userID;
        this.name = name;
        this.address = address;
        this.menus = menus;
    }

    public Restaurant(Long id, Long userID, String name, String address, ArrayList<Menu> menus, User user) {
        this.id = id;
        this.userID = userID;
        this.name = name;
        this.address = address;
        this.menus = menus;
        this.user = user;
    }

    public Restaurant() {
    }

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
        this.menus = new ArrayList<Menu>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void createMenu() {
        this.menus.add(new Menu());
    }

    public Menu getMenu(String name) {
        for (Menu menu : this.menus) {
            if (menu.getName().equals(name)) {
                return menu;
            }
        }
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Menu> getMenus() {
        return menus;
    }

    public void setMenus(ArrayList<Menu> menus) {
        this.menus = menus;
    }
}
