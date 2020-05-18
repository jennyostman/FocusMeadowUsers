package exarb.fmusers.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserWeb {

    private String id;
    @NotBlank(message = "Name must not be empty")
    private String firstName;
    @NotBlank(message = "Name must not be empty")
    private String lastName;
    @NotBlank(message = "Usernamne must not be empty")
    private String userName;
    @NotBlank(message = "Email must not be empty")
    private String email;
    @NotBlank(message = "Password must not be empty")
    private String password;

}
