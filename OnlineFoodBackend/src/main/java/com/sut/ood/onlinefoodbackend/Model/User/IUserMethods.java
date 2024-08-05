package com.sut.ood.onlinefoodbackend.Model.User;

import com.sut.ood.onlinefoodbackend.Model.Enum.Response;

public interface IUserMethods {
    Response validateUsername(String username);
    Response validatePhoneNumber(String phoneNumber);
    Response validateEmail(String email);
    Response validateSignUp(UserSignUpCredentials signUpCredentials);
    Response validatePasswordCorrection(String username, String password);
    Response validateUserSignUpConfirmation(String username);
    Response validateSignIn(UserSignInCredentials userSignInCredentials);
    Response signUp(UserSignUpCredentials signUpCredentials);
    Response signIn(UserSignInCredentials userSignInCredentials);
    Response signOut(String token);
}
