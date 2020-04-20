package exarb.fmusers.controller;

import exarb.fmusers.model.User;
import exarb.fmusers.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/users", produces = APPLICATION_JSON_VALUE)
public class UserController {

    // TODO: denna klass används inte

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createNewUser(@NotNull @RequestBody User user) {
        return ResponseEntity.ok().body(userService.createNewUser(user));
    }


}
