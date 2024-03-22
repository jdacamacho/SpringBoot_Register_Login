package com.unicauca.authentication.Infrastructure.Input.ControllerManageUser.DTOResponse;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTOResponse {
    private long idUser;
    private long numberDocument;
    private String names;
    private String lastNames;
    private CredentionalDTOResponse credential;
    private List<RoleDTOResponse> roles;

    public UserDTOResponse(){
        this.roles = new ArrayList<>();
    }
}
