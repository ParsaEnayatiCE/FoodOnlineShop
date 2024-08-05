package com.sut.ood.onlinefoodbackend.Contoller.Handlers;

import com.sut.ood.onlinefoodbackend.Model.Enum.Response;
import com.sut.ood.onlinefoodbackend.Model.User.UserManagement;
import com.sut.ood.onlinefoodbackend.Model.User.UserSignInCredentials;
import com.sut.ood.onlinefoodbackend.Model.User.UserSignUpCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class SignInHandler {
    protected SignInHandler nextHandler;
    @Autowired
    UserManagement userManagement;

    public void setNextHandler(SignInHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract Response handle(UserSignInCredentials user);
}
