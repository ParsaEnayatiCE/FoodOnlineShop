package com.sut.ood.onlinefoodbackend.Model.User;

import com.sut.ood.onlinefoodbackend.Contoller.Handlers.*;
import com.sut.ood.onlinefoodbackend.Model.DatabaseFacade;
import com.sut.ood.onlinefoodbackend.Model.Enum.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.sut.ood.onlinefoodbackend.Model.Enum.Response.*;
import static com.sut.ood.onlinefoodbackend.Model.Enum.Response.PHONE_NUMBER_PATTERN_NOT_MATCHED;

@Service
public class UserManagement implements IUserMethods,IPatternChecker{

    @Autowired
    DatabaseFacade databaseFacade;
    @Autowired
    private SignInHandler signInHandlerChain;
    @Autowired
    private SignUpHandler signUpHandlerChain;

    @Override
    public Response validateUsername(String username) {
        User user = databaseFacade.findUserByUsername(username);
        return Objects.nonNull(user) ? USER_NAME_ALREADY_EXIST : USER_NAME_NOT_EXIST;
    }

    @Override
    public Response validatePhoneNumber(String phoneNumber) {
        if (Objects.isNull(databaseFacade.findUserByPhone(phoneNumber))) {
            return PHONE_NUMBER_ALREADY_EXIST;
        }
        return validatePhoneNumberPattern(phoneNumber);
    }

    @Override
    public Response validateEmail(String email) {
        if (Objects.isNull(databaseFacade.findUserByEmail(email))) {
            return EMAIL_ALREADY_EXIST;
        }
        return validateEmailPattern(email);
    }

    @Override
    public Response validatePasswordCorrection(String username, String password) {
        User user = databaseFacade.findUserByUsername(username);
        return user.getPassword().equals(password) ? PASSWORD_IS_CORRECT : PASSWORD_IS_INCORRECT;
    }

    @Override
    public Response validateUserSignUpConfirmation(String username) {
        User user = databaseFacade.findUserByUsername(username);
        return user.isConfirmedByAdmin() ? USER_CONFIRMED_BY_ADMIN : USER_NOT_CONFIRMED_BY_ADMIN;
    }

    @Override
    public Response validateSignUp(UserSignUpCredentials userSignUpCredentials) {
        return signUpHandlerChain.handle(userSignUpCredentials);
    }

    @Override
    public Response validateSignIn(UserSignInCredentials userSignInCredentials) {
        return signInHandlerChain.handle(userSignInCredentials);
    }

    @Override
    public Response signUp(UserSignUpCredentials signUpCredentials) {
        Response validateSignUpResponse = validateSignUp(signUpCredentials);
        if (validateSignUpResponse.equals(PHONE_NUMBER_PATTERN_MATCHED)){
            return databaseFacade.addUser(signUpCredentials.getUserFromUserCredentials());
        }
        return validateSignUpResponse;
    }

    @Override
    public Response signIn(UserSignInCredentials userSignInCredentials) {
        Response validateSignInResponse = validateSignIn(userSignInCredentials);
        if (validateSignInResponse.equals(USER_CONFIRMED_BY_ADMIN)){
            return USER_SIGN_IN_SUCCESSFULLY;
        }
        return validateSignInResponse;
    }

    //TODO
    @Override
    public Response signOut(String token) {
        return USER_SIGN_OUT_SUCCESSFULLY;
    }


    //Password must contain at least 8 characters include a lowercase and an uppercase alphabet and at least a number
    @Override
    public Response validatePasswordPattern(String password) {
        String pPattern = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$";
        Pattern p = java.util.regex.Pattern.compile(pPattern);
        Matcher m = p.matcher(password);
        return m.matches() ? PASSWORD_PATTERN_MATCHED : PASSWORD_PATTERN_NOT_MATCHED;
    }

    @Override
    public Response validatePasswordConfirmation(String password, String confirmation) {
        return Objects.equals(password, confirmation) ? PASSWORD_AND_CONFIRM_PASSWORD_MATCHED : PASSWORD_AND_CONFIRM_PASSWORD_NOT_MATCHED;
    }

    //email address : example@gmail.com
    @Override
    public Response validateEmailPattern(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern p = java.util.regex.Pattern.compile(ePattern);
        Matcher m = p.matcher(email);
        return m.matches() ? EMAIL_PATTERN_MATCHED : EMAIL_PATTERN_NOT_MATCHED;
    }

    @Override
    public Response validatePhoneNumberPattern(String phone) {
        String pPattern = "^(\\+98|0098|0)?9\\d{9}$";
        Pattern pattern = Pattern.compile(pPattern);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches() ? PHONE_NUMBER_PATTERN_MATCHED : PHONE_NUMBER_PATTERN_NOT_MATCHED;
    }
}
