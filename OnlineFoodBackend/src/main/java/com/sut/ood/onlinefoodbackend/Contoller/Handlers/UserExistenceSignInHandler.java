package com.sut.ood.onlinefoodbackend.Contoller.Handlers;

import com.sut.ood.onlinefoodbackend.Model.Enum.Response;
import com.sut.ood.onlinefoodbackend.Model.User.UserSignInCredentials;
import org.springframework.stereotype.Component;

@Component
public class UserExistenceSignInHandler extends SignInHandler{
    @Override
    public Response handle(UserSignInCredentials user) {
        Response response = userManagement.validateUsername(user.getUsername());
        if (response.equals(Response.USER_NAME_ALREADY_EXIST)) {
            return response;
        }
        return nextHandler.handle(user);
    }
}
