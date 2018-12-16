package org.zeti.medical.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import org.zeti.medical.json.view.UserView;
import org.zeti.medical.services.UserAccountServices;
import org.zeti.medical.validation.group.UserAccountGroup;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;

// Accesible only for Admin
@CrossOrigin(origins = "*", maxAge = 3600)
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
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/users/active-users")
    public ResponseEntity<?> getAllActiveUser()
    {
        System.out.println("Testing");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getAuthorities().iterator().next();
        System.out.println("Role is " + principal.toString());
        return new ResponseEntity<>(userAccountServices.findAllUserDetails(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/users/inactive-users")
    @JsonView(UserView.inactive.class)
    public ResponseEntity<?> getAllInactiveUser()
    {
        return new ResponseEntity<>(userAccountServices.findAllInactiveUser(), HttpStatus.OK);
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

    // delete one user
    @DeleteMapping("/users/{userID}")
    public ResponseEntity<?> deleteUser(@PathVariable(name = "userID") Integer userID)
    {
        userAccountServices.deleteByID(userID);
        return ResponseEntity.ok("Successfully Deleted");
    }

    @DeleteMapping("/users/inactive-users")
    public ResponseEntity<?> deleteInactiveUsers()
    {
        userAccountServices.deleteAllInactiveUser();
        return ResponseEntity.ok("Successfully Deleted");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/generate-dummy-password")
    public ResponseEntity<?> createDummyPassword(@RequestBody String password)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String passwordEncoded = encoder.encode("testing");
        return ResponseEntity.ok(passwordEncoded);
    }
}
