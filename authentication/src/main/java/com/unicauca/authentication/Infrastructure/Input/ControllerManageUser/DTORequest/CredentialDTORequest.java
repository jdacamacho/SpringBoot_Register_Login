package com.unicauca.authentication.Infrastructure.Input.ControllerManageUser.DTORequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CredentialDTORequest {
    @NotNull(message = "Username can't be null")
    @NotBlank(message = "Username can't be empty")
    private String userName;

    @NotNull(message = "Password can't be null")
    @NotBlank(message = "Password can't be empty")
    private String password;

    public CredentialDTORequest(){

    }
}
