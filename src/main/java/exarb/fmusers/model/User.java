package exarb.fmusers.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class User {

    private String id;
    private String name;
    private String surName;
    private String username;
    private String email;
    private String password;

}
