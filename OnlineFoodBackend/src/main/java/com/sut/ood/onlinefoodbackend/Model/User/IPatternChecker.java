package com.sut.ood.onlinefoodbackend.Model.User;

import com.sut.ood.onlinefoodbackend.Model.Enum.Response;

public interface IPatternChecker {
    Response validatePasswordConfirmation(String password, String confirmation);
    Response validatePasswordPattern(String password);
    Response validateEmailPattern(String email);
    Response validatePhoneNumberPattern(String phone);
}
