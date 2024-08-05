package com.sut.ood.onlinefoodbackend.Model.Customer;

import jakarta.persistence.*;

import java.util.Date;

@Table(name = "REVIEW")
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TEXT")
    private String text;
    @Column(name = "SCORE")
    private int score;
    @Column(name = "DATE_SUBMIT")
    private Date dateSubmit;
    @Column(name = "ORDER_ID")
    private Long orderID;

    public Review() {
    }

    public Review(String text, int score, Date dateSubmit, Long orderID) {
        this.text = text;
        this.score = score;
        this.dateSubmit = dateSubmit;
        this.orderID = orderID;
    }

    public Review(Long id, String text, int score, Date dateSubmit, Long orderID) {
        this.id = id;
        this.text = text;
        this.score = score;
        this.dateSubmit = dateSubmit;
        this.orderID = orderID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getDateSubmit() {
        return dateSubmit;
    }

    public void setDateSubmit(Date dateSubmit) {
        this.dateSubmit = dateSubmit;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }
}
