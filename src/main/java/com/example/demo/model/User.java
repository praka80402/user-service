package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@NamedStoredProcedureQuery(
        name = "User.getUserByEmail",
        procedureName = "get_user_by_email",
        resultClasses = User.class,
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "email_input", type = String.class)
        }
)
public class User {

    @Id
    private Long id;
    @Column
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @Column
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
// Getters and Setters
}
