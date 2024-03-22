package com.unicauca.authentication.Infrastructure.Input.ControllerManageUser.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.unicauca.authentication.Domain.Models.User;
import com.unicauca.authentication.Infrastructure.Input.ControllerManageUser.DTORequest.UserDTORequest;
import com.unicauca.authentication.Infrastructure.Input.ControllerManageUser.DTOResponse.UserDTOResponse;

@Mapper(componentModel = "spring")
public interface UserMapperInfrastuctureDomain {
    User mapRequestToUser(UserDTORequest userRequest);
    UserDTOResponse mapUserToResponse(User user);
    List<UserDTOResponse> mapUsersToResponse(List<User> users);
}