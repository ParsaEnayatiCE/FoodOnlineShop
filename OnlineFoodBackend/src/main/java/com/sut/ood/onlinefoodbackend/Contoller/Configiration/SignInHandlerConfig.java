package com.sut.ood.onlinefoodbackend.Contoller.Configiration;

import com.sut.ood.onlinefoodbackend.Contoller.Handlers.PasswordCorrectionHandler;
import com.sut.ood.onlinefoodbackend.Contoller.Handlers.SignInHandler;
import com.sut.ood.onlinefoodbackend.Contoller.Handlers.UserExistenceSignInHandler;
import com.sut.ood.onlinefoodbackend.Contoller.Handlers.UserSignUpConfirmationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SignInHandlerConfig {
    @Autowired
    private UserExistenceSignInHandler userExistenceSignInHandler;
    @Autowired
    private PasswordCorrectionHandler passwordCorrectionHandler;
    @Autowired
    private UserSignUpConfirmationHandler userConfirmedHandler;
    @Bean
    public SignInHandler signInHandlerChain() {
        userExistenceSignInHandler.setNextHandler(passwordCorrectionHandler);
        passwordCorrectionHandler.setNextHandler(userConfirmedHandler);
        return userExistenceSignInHandler;
    }
}
