package com.unicauca.authentication.Domain.userCases;

import java.util.List;

import com.unicauca.authentication.Application.Input.ManageUserCUIntPort;
import com.unicauca.authentication.Application.Output.ExceptionFormatterIntPort;
import com.unicauca.authentication.Application.Output.ManageUserGatewayIntPort;
import com.unicauca.authentication.Domain.Models.User;

public class ManageUserCUImplAdapter implements ManageUserCUIntPort{
    private final ManageUserGatewayIntPort gatewayUser;
    private final ExceptionFormatterIntPort formatterUser;

    public ManageUserCUImplAdapter(
        ManageUserGatewayIntPort gatewayUser,
        ExceptionFormatterIntPort formatterUser
    ){
        this.gatewayUser = gatewayUser;
        this.formatterUser = formatterUser;
    }

    @Override
    public List<User> listUsers() {
        return this.gatewayUser.findAll();
    }

    @Override
    public User createUser(User user) {
        User userResponse = null;
        if(this.gatewayUser.findById(user.getIdUser()) != null){
            this.formatterUser.returnResponseErrorEntityExists("User with id exists in the system");
        }else{
            userResponse = this.gatewayUser.save(userResponse);
        }
        return userResponse;
    }

    @Override
    public User updateUser(long idUser, User user) {
        User userResponse = null;
        if(this.gatewayUser.findById(idUser) == null){
            this.formatterUser.returnResponseErrorEntityNotFound("User not found");
        }else{
            userResponse = this.gatewayUser.save(userResponse);
        }
        return userResponse;
    }

    @Override
    public boolean deleteUser(long idUser) {
        boolean flagResponse = false;
        User user = this.gatewayUser.findById(idUser);
        if(user == null){
            this.formatterUser.returnResponseErrorEntityNotFound("User not found");
        }else{
            this.gatewayUser.delete(user);
            flagResponse = true;
        }
        return flagResponse;
    }

    @Override
    public User getUser(long idUser) {
        User userResponse = this.gatewayUser.findById(idUser);
        if(userResponse == null){
            this.formatterUser.returnResponseErrorEntityNotFound("User not found");
        }
        return userResponse;
    }

    
}
