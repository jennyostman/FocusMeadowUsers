package exarb.fmusers.model;

import lombok.Data;

/**
 * Model for a users web registration data
 */
@Data
public class UserWeb {

    private String id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;

}
