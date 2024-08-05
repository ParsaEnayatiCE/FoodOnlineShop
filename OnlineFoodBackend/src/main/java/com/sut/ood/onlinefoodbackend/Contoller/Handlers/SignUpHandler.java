package com.sut.ood.onlinefoodbackend.Contoller.Handlers;

import com.sut.ood.onlinefoodbackend.Model.DatabaseFacade;
import com.sut.ood.onlinefoodbackend.Model.Enum.Response;
import com.sut.ood.onlinefoodbackend.Model.User.UserManagement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Map;
import com.sut.ood.onlinefoodbackend.Model.User.*;
import org.springframework.stereotype.Component;

@Component
public abstract class SignUpHandler {
    protected SignUpHandler nextHandler;
    @Autowired
    UserManagement userManagement;

    public void setNextHandler(SignUpHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract Response handle(UserSignUpCredentials user);
}