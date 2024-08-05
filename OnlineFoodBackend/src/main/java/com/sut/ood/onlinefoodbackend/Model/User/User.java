package com.sut.ood.onlinefoodbackend.Model.User;


import jakarta.persistence.*;

@Table(name = "USERS")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "USER_NAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "USER_TYPE")
    private String userType;
    @Column(name = "IS_CONFIRMED_BY_ADMIN")
    private boolean confirmedByAdmin;


    @Transient
    private UserDocument documents;

    public User() {
    }

    public User(Long id, String username, String password, String email, String phoneNumber, String userType, boolean confirmedByAdmin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.confirmedByAdmin = confirmedByAdmin;
    }

    public User(String username, String password, String email, String phoneNumber, String userType, boolean confirmedByAdmin) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.confirmedByAdmin = confirmedByAdmin;
    }

    public User(String username, String password, String email, String phoneNumber, String userType, boolean confirmedByAdmin, UserDocument userDocument) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
        this.confirmedByAdmin = confirmedByAdmin;
        this.documents = userDocument;
    }





    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserDocument getDocuments() {
        return documents;
    }

    public void setDocuments(UserDocument documents) {
        this.documents = documents;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public boolean isConfirmedByAdmin() {
        return confirmedByAdmin;
    }

    public void setConfirmedByAdmin(boolean confirmedByAdmin) {
        this.confirmedByAdmin = confirmedByAdmin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
