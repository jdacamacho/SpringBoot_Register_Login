package com.unicauca.authentication.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Role {
    private long idRole;
    private String roleName;

    public Role(){
        
    }

}
