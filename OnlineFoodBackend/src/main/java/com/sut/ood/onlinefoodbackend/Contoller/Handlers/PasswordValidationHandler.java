package com.sut.ood.onlinefoodbackend.Contoller.Handlers;

import com.sut.ood.onlinefoodbackend.Model.Enum.Response;
import com.sut.ood.onlinefoodbackend.Model.User.UserSignUpCredentials;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidationHandler extends SignUpHandler {
    @Override
    public Response handle(UserSignUpCredentials user) {
        Response response = userManagement.validatePasswordPattern(user.getPassword());
        if (response.equals(Response.PASSWORD_PATTERN_NOT_MATCHED)) {
            return response;
        }
        return nextHandler.handle(user);
    }
}