package com.sut.ood.onlinefoodbackend.Model.User;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sut.ood.onlinefoodbackend.Model.Enum.UserType;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
public class UserSignUpCredentials {

    @Valid
    @NotNull(message = "UserName can't be null!")
    @JsonProperty("username")
    private String username;

    @Valid
    @NotNull(message = "Password can't be null!")
    @JsonProperty("password")
    private String password;
    @Valid
    @NotNull(message = "Password can't be null!")
    @JsonProperty("passwordConfirmation")
    private String passwordConfirmation;
    @Valid
    @NotNull(message = "Email can't be null!")
    @JsonProperty("email")
    private String email;
    @Valid
    @NotNull(message = "PhoneNumber can't be null!")
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @Valid
    @NotNull(message = "UserType can't be null!")
    @JsonProperty("userType")
    private UserType userType;

    public UserSignUpCredentials() {
    }

    public UserSignUpCredentials(String username, String password, String passwordConfirmation, String email, String phoneNumber, UserType userType) {
        this.username = username;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
    }

    public User getUserFromUserCredentials() {
        return new User(this.username, this.password, this.email, this.phoneNumber, userType.toString(), false);
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

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
