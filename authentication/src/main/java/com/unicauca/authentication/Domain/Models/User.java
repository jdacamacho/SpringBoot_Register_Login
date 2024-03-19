package com.unicauca.authentication.Domain.Models;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private long idUser;
    private long numberDocument;
    private String names;
    private String lastNames;
    private Credential credential;
    private List<Role> roles;

    public User(){
        this.roles = new ArrayList<>();
    }
}