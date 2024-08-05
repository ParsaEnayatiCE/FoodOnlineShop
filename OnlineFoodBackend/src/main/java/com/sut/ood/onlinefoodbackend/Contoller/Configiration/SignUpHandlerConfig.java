package com.sut.ood.onlinefoodbackend.Contoller.Configiration;

import com.sut.ood.onlinefoodbackend.Contoller.Handlers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SignUpHandlerConfig {
    @Autowired
    private UserExistenceSignUpHandler userExistenceHandler;
    @Autowired
    private PasswordValidationHandler passwordValidationHandler;
    @Autowired
    private PasswordConfirmationHandler passwordConfirmationHandler;
    @Autowired
    private EmailValidationHandler emailValidationHandler;
    @Autowired
    private PhoneNumberValidationHandler phoneNumberValidationHandler;
    @Bean
    public SignUpHandler signUpHandlerChain() {
        userExistenceHandler.setNextHandler(passwordValidationHandler);
        passwordValidationHandler.setNextHandler(passwordConfirmationHandler);
        passwordConfirmationHandler.setNextHandler(emailValidationHandler);
        emailValidationHandler.setNextHandler(phoneNumberValidationHandler);
        return userExistenceHandler;
    }
}
