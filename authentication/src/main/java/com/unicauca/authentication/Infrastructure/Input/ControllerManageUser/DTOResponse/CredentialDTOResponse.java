package com.unicauca.authentication.Infrastructure.Input.ControllerManageUser.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CredentialDTOResponse {
    private long idCredential;
    private String userName;
    private String password;
    private UserDTOResponse objUser;

    public CredentialDTOResponse(){

    }
}
