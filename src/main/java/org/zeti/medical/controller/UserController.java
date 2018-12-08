package org.zeti.medical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.zeti.medical.entity.UserAccount;
import org.zeti.medical.services.UserAccountServices;
import org.zeti.medical.validation.group.UserAccountGroup;

import javax.validation.Valid;
import java.net.URI;

// Accesible only for Admin

@RestController
@RequestMapping(value = "/zeti/admin")
public class UserController
{

    @Autowired
    private UserAccountServices userAccountServices;

    @GetMapping("/users")
    public ResponseEntity<?> getAllUser()
    {
        return new ResponseEntity<>(userAccountServices.findAllUserDetails(), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<?> createNewUser(@RequestBody @Valid UserAccount userAccount)
    {
        userAccountServices.saveOrUpdate(userAccount);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(userAccount.getUserID()).toUri();
        return ResponseEntity.created(location).body("Successfully Created");
    }
}
