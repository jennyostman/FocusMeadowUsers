package exarb.fmusers.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserWeb {

    private String id;
    @NotEmpty(message = "Name must not be empty")
    private String firstName;
    @NotEmpty(message = "Name must not be empty")
    private String lastName;
    @NotEmpty(message = "Usernamne must not be empty")
    private String userName;
    @NotEmpty(message = "Email must not be empty")
    private String email;
    @NotEmpty(message = "Password must not be empty")
    private String password;

}
