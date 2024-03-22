package com.unicauca.authentication.Infrastructure.Input.ControllerManageUser.DTORequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoleDTORequest {
    @NotNull(message = "idRole can't be null")
    @NotBlank(message = "idRole can't be empty")
    private long idRole;

    @NotNull(message = "idRole can't be null")
    @NotBlank(message = "idRole can't be empty")
    private String roleName;

    public RoleDTORequest(){

    }
}
