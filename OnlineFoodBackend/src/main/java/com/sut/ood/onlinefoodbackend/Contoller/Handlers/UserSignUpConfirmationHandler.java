package com.sut.ood.onlinefoodbackend.Contoller.Handlers;

import com.sut.ood.onlinefoodbackend.Model.Enum.Response;
import com.sut.ood.onlinefoodbackend.Model.User.UserSignInCredentials;
import org.springframework.stereotype.Component;

@Component
public class UserSignUpConfirmationHandler extends SignInHandler{
    @Override
    public Response handle(UserSignInCredentials user) {
        return userManagement.validateUserSignUpConfirmation(user.getUsername());
    }
}