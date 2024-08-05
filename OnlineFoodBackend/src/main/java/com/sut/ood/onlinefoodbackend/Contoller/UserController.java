package com.sut.ood.onlinefoodbackend.Contoller;

import com.sut.ood.onlinefoodbackend.Model.DatabaseFacade;
import com.sut.ood.onlinefoodbackend.Model.Enum.Response;
import com.sut.ood.onlinefoodbackend.Model.User.User;
import com.sut.ood.onlinefoodbackend.Model.User.UserManagement;
import com.sut.ood.onlinefoodbackend.Model.User.UserSignUpCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.sut.ood.onlinefoodbackend.Model.Enum.Response.USER_SAVED_SUCCESSFULLY;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserManagement userManagement;
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<String> func(@RequestBody @Validated UserSignUpCredentials userSignUpCredentials, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMessage.append(error.getDefaultMessage()).append(" ");
            }
            return ResponseEntity.badRequest().body(errorMessage.toString());
        }
        Response response = userManagement.signUp(userSignUpCredentials);
        if (response.equals(USER_SAVED_SUCCESSFULLY)) {
            return ResponseEntity.ok(response.toString());
        } else {
            return ResponseEntity.status(500).body(response.toString());
        }
    }
}
