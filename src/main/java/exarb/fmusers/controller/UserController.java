package exarb.fmusers.controller;

import exarb.fmusers.exception.RegistrationException;
import exarb.fmusers.model.LoginWeb;
import exarb.fmusers.model.User;
import exarb.fmusers.model.UserWeb;
import exarb.fmusers.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotNull;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/users", produces = APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;


    /**
     * Creates a new user
     * @param userWeb user data
     * @return User
     */
    @PostMapping(value="/registration", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity createNewUser(@NotNull @RequestBody UserWeb userWeb) {
        try {
            return ResponseEntity.ok().body(userService.createNewUser(userWeb));
        } catch (RegistrationException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Username or email already registered", ex);
        }
    }

    /**
     * Logs in a user
     * @param LoginWeb a users login data
     * @return User
     */
    @PostMapping(value="/login", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity logInUser(@NotNull @RequestBody LoginWeb LoginWeb) {
        try {
            return ResponseEntity.ok().body(userService.logInUser(LoginWeb));
        } catch (RegistrationException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Wrong username or password", ex);
        }
    }

    /**
     * Gets a user by userId
     * @param userId a users id
     * @return User
     */
    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId) {
        return ResponseEntity.ok().body(userService.getUserById(userId));
    }
}
