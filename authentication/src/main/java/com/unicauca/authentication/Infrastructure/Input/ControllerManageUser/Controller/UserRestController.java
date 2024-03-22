package com.unicauca.authentication.Infrastructure.Input.ControllerManageUser.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.authentication.Application.Input.ManageUserCUIntPort;
import com.unicauca.authentication.Domain.Models.User;
import com.unicauca.authentication.Infrastructure.Input.ControllerManageUser.DTORequest.UserDTORequest;
import com.unicauca.authentication.Infrastructure.Input.ControllerManageUser.DTOResponse.UserDTOResponse;
import com.unicauca.authentication.Infrastructure.Input.ControllerManageUser.mappers.UserMapperInfrastuctureDomain;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/apiUser")
@Validated
@RequiredArgsConstructor
public class UserRestController {
    private final ManageUserCUIntPort userCU;
    private final UserMapperInfrastuctureDomain mapper;

    @GetMapping("/users")
    @Transactional(readOnly = true)
    public ResponseEntity<List<UserDTOResponse>> listUsers(){
        List<User> users = this.userCU.listUsers();
        ResponseEntity<List<UserDTOResponse>> objResponse = new ResponseEntity<List<UserDTOResponse>>(
            this.mapper.mapUsersToResponse(users),HttpStatus.OK);
        return objResponse;
    }

    @GetMapping("/users/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<UserDTOResponse> getUser(@PathVariable long idUser){
        User user = this.userCU.getUser(idUser);
        ResponseEntity<UserDTOResponse> objResponse = new ResponseEntity<UserDTOResponse>(
            this.mapper.mapUserToResponse(user),HttpStatus.OK);
        return objResponse;
    }

    @PostMapping("/users")
    @Transactional(readOnly = false)
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserDTORequest userRequest, BindingResult result){
        User user = this.mapper.mapRequestToUser(userRequest);
        Map<String,Object> response = new HashMap<>();
        UserDTOResponse objUserResponse;

        if(result.hasErrors()){
            List<String> errorList = new ArrayList<>();

            for(FieldError error : result.getFieldErrors()){
                errorList.add("Field " + error.getField() + " " + error.getDefaultMessage());
            }

            response.put("errors", errorList);
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
        }

        try{
            objUserResponse = this.mapper.mapUserToResponse(this.userCU.createUser(user));
        }catch(DataAccessException e){
            response.put("message", "Error when inserting into the database");
            response.put("error", e.getMessage() + " " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<UserDTOResponse>(objUserResponse,HttpStatus.OK);
        
    }

    @PutMapping("/users/{idUser}")
    @Transactional(readOnly = false)
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserDTORequest userRequest,@PathVariable long idUser, BindingResult result){
        User user = this.mapper.mapRequestToUser(userRequest);
        Map<String,Object> response = new HashMap<>();
        UserDTOResponse objUserResponse;

        if(result.hasErrors()){
            List<String> errorList = new ArrayList<>();

            for(FieldError error : result.getFieldErrors()){
                errorList.add("Field " + error.getField() + " " + error.getDefaultMessage());
            }

            response.put("errors", errorList);
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
        }

        try{
            objUserResponse = this.mapper.mapUserToResponse(this.userCU.updateUser(idUser, user));
        }catch(DataAccessException e){
            response.put("message", "Error when inserting into the database");
            response.put("error", e.getMessage() + " " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<UserDTOResponse>(objUserResponse,HttpStatus.OK);
        
    }

    @DeleteMapping("/users/{idUser}")
    @Transactional(readOnly = false)
    public ResponseEntity<?> deleteUser(@PathVariable long idUser){
        boolean flagResponse = false;
        Map<String,Object> response = new HashMap<>();
        try{
            flagResponse = this.userCU.deleteUser(idUser);
        }catch(DataAccessException e){
            response.put("message", "Error when inserting into the database");
            response.put("error", e.getMessage() + " " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("status", flagResponse);
        response.put("message", "User has been eliminated");
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }
}
