package org.zeti.medical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /*
        NOTE: this api has no pagination, the reason why is the number of employees is few
     */
    /*
        Angular
        NOTE: please use angular pagination
     */
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

    @PutMapping("/users")
    public ResponseEntity<?> deactivateUser(@RequestParam(name = "userID") Integer userID)
    {
        userAccountServices.deactivateUser(userID);
        return ResponseEntity.ok("Successfully deactivated");
    }

    @DeleteMapping("/users")
    public ResponseEntity<?> deleteUser(@RequestParam(name = "userID") Integer userID)
    {
        userAccountServices.deleteByID(userID);
        return ResponseEntity.ok("Successfully Deleted");
    }
}
