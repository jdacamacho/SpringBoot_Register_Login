package com.unicauca.authentication.Infrastructure.Input.ControllerManageUser.DTORequest;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTORequest {    
    @Positive(message = "numberDocument must be major than zero")
    @Min(value = 1000000000L,message = "numberDocument must have at least ten digits")
    private long numberDocument;
    
    @NotNull(message = "Names can't be null")
    @NotBlank(message = "Names can't be empty")
    private String names;

    @NotNull(message = "LastNames can't be null")
    @NotBlank(message = "LastNames can't be empty")
    private String lastNames;
    
    @Valid
    @NotNull(message = "User must have his own credential")
    private CredentialDTORequest credential;
    
    @Valid
    @Size(min = 1,message = "User must have at least one role")
    private List<RoleDTORequest> roles;

    public UserDTORequest(){
        this.roles = new ArrayList<>();
    }
}
