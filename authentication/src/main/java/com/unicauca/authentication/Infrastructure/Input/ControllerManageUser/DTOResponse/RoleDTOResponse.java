package com.unicauca.authentication.Infrastructure.Input.ControllerManageUser.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoleDTOResponse {
    private long idRole;
    private String roleName;

    public RoleDTOResponse(){
        
    }
}
