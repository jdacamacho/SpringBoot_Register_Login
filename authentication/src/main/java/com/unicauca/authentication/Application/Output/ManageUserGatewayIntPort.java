package com.unicauca.authentication.Application.Output;

import java.util.List;

import com.unicauca.authentication.Domain.Models.User;

public interface ManageUserGatewayIntPort {
    public List<User> findAll();
    public User save(User user);
    public void delete(User user);
    public User findById(long idUser);
}
