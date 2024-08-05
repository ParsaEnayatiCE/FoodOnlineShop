package com.sut.ood.onlinefoodbackend.Contoller.Handlers;

import com.sut.ood.onlinefoodbackend.Model.Enum.Response;
import com.sut.ood.onlinefoodbackend.Model.User.UserSignUpCredentials;
import org.springframework.stereotype.Component;

@Component
public class EmailValidationHandler extends SignUpHandler {
    @Override
    public Response handle(UserSignUpCredentials user) {
        Response response = userManagement.validateEmail(user.getEmail());
        if (response.equals(Response.EMAIL_PATTERN_NOT_MATCHED) || response.equals(Response.EMAIL_ALREADY_EXIST)) {
            return response;
        }
        return nextHandler.handle(user);
    }
}
