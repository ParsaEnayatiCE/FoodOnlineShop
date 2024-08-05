package com.sut.ood.onlinefoodbackend.Contoller.Handlers;

import com.sut.ood.onlinefoodbackend.Model.Enum.Response;
import com.sut.ood.onlinefoodbackend.Model.User.UserSignUpCredentials;
import org.springframework.stereotype.Component;

@Component
public class PasswordConfirmationHandler extends SignUpHandler {
    @Override
    public Response handle(UserSignUpCredentials user) {
        Response response = userManagement.validatePasswordConfirmation(user.getPassword(), user.getPasswordConfirmation());
        if (response.equals(Response.PASSWORD_AND_CONFIRM_PASSWORD_NOT_MATCHED)) {
            return response;
        }
        return nextHandler.handle(user);
    }
}
