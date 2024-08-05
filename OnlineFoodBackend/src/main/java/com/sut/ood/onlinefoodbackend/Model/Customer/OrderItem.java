package com.sut.ood.onlinefoodbackend.Model.Customer;

import com.sut.ood.onlinefoodbackend.Model.Restaurant.MenuItem;
import jakarta.persistence.*;

@Table(name = "ORDER_ITEM")
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long ID;
    @Column(name = "COUNT")
    private int count;
    @Column(name = "ORDER_ID")
    private Long orderID;
    @Column(name = "MENU_ITEM_ID")
    private Long menuItemID;

    @Transient
    private MenuItem menuItem;

    public OrderItem(Long ID, int count, Long orderID, Long menuItemID) {
        this.ID = ID;
        this.count = count;
        this.orderID = orderID;
        this.menuItemID = menuItemID;
    }

    public OrderItem(int count, Long orderID, Long menuItemID) {
        this.count = count;
        this.orderID = orderID;
        this.menuItemID = menuItemID;
    }


    public OrderItem(Long ID, int count, Long orderID, Long menuItemID, MenuItem menuItem) {
        this.ID = ID;
        this.count = count;
        this.orderID = orderID;
        this.menuItemID = menuItemID;
        this.menuItem = menuItem;
    }



    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public OrderItem() {

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public Long getMenuItemID() {
        return menuItemID;
    }

    public void setMenuItemID(Long menuItemID) {
        this.menuItemID = menuItemID;
    }
}
