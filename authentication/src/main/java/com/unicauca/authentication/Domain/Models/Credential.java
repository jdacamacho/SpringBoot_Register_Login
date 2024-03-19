package com.unicauca.authentication.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Credential {
    private long idCredential;
    private String userName;
    private String password;
    private User objUser;
    
    public Credential(){
        
    }
}
