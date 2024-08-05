package com.sut.ood.onlinefoodbackend.Contoller.Handlers;

import com.sut.ood.onlinefoodbackend.Model.Enum.Response;
import com.sut.ood.onlinefoodbackend.Model.User.UserSignInCredentials;
import com.sut.ood.onlinefoodbackend.Model.User.UserSignUpCredentials;
import org.springframework.stereotype.Component;

import static com.sut.ood.onlinefoodbackend.Model.Enum.Response.PASSWORD_CORRECTION_SUCCESS;

@Component
public class PasswordCorrectionHandler extends SignInHandler{
    @Override
    public Response handle(UserSignInCredentials user) {
        Response response = userManagement.validatePasswordCorrection(user.getUsername(), user.getPassword());
        if (response.equals(Response.PASSWORD_CORRECTION_NOT_SUCCESS)) {
            return response;
        }
        return nextHandler.handle(user);
    }
}
