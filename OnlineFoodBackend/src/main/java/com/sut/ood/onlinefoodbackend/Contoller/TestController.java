package com.sut.ood.onlinefoodbackend.Contoller;

import com.sut.ood.onlinefoodbackend.Model.DatabaseFacade;
import com.sut.ood.onlinefoodbackend.Model.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    @Autowired
    private DatabaseFacade databaseFacade;
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ResponseEntity<String> func(@RequestBody String text) {
        return ResponseEntity.ok(text + " was received");
    }
}
