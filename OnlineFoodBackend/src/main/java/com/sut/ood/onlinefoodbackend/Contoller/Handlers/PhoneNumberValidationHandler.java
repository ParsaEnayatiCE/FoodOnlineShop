package com.sut.ood.onlinefoodbackend.Contoller.Handlers;

import com.sut.ood.onlinefoodbackend.Model.Enum.Response;
import com.sut.ood.onlinefoodbackend.Model.User.UserSignUpCredentials;
import org.springframework.stereotype.Component;

@Component
public class PhoneNumberValidationHandler extends SignUpHandler {
    @Override
    public Response handle(UserSignUpCredentials user) {
        Response response = userManagement.validatePhoneNumber(user.getPhoneNumber());
        if (response.equals(Response.PHONE_NUMBER_PATTERN_NOT_MATCHED) || response.equals(Response.PHONE_NUMBER_ALREADY_EXIST)) {
            return response;
        }
        return Response.PHONE_NUMBER_PATTERN_MATCHED;
    }
}
