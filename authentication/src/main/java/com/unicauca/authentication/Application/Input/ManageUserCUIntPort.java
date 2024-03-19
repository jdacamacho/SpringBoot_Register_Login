package com.unicauca.authentication.Application.Input;

import java.util.List;

import com.unicauca.authentication.Domain.Models.User;

public interface ManageUserCUIntPort {
    public List<User> listUsers();
    public User createUser(User user);
    public User updateUser(long idUser,User user);
    public boolean deleteUser(long idUser);
    public User getUser(long idUser);
}
