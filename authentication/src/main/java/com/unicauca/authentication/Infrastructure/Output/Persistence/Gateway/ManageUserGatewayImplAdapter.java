package com.unicauca.authentication.Infrastructure.Output.Persistence.Gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.unicauca.authentication.Application.Output.ManageUserGatewayIntPort;
import com.unicauca.authentication.Domain.Models.User;
import com.unicauca.authentication.Infrastructure.Output.Persistence.Entities.UserEntity;
import com.unicauca.authentication.Infrastructure.Output.Persistence.Repositories.UserRepository;

@Service
public class ManageUserGatewayImplAdapter implements ManageUserGatewayIntPort{
    private final UserRepository serviceAccessBD;
    private final ModelMapper mapper;

    public ManageUserGatewayImplAdapter(
        UserRepository serviceAccessBD,
        ModelMapper mapper
    ){
        this.serviceAccessBD = serviceAccessBD;
        this.mapper = mapper;
    }

    @Override
    public List<User> findAll() {
        Iterable<UserEntity> iterableUser = this.serviceAccessBD.findAll();
        List<User> userListResponse = this.mapper.map(iterableUser,new TypeToken<List<User>>(){}.getType());
        return userListResponse;
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = this.mapper.map(user, UserEntity.class);
        UserEntity userSaved = this.serviceAccessBD.save(userEntity);
        User userResponse = this.mapper.map(userSaved, User.class);
        return userResponse;
    }

    @Override
    public void delete(User user) {
        UserEntity userEntity = this.mapper.map(user, UserEntity.class);
        this.serviceAccessBD.delete(userEntity);
    }

    @Override
    public User findById(long idUser) {
        UserEntity userEntity = this.serviceAccessBD.findById(idUser).get();
        User userResponse = this.mapper.map(userEntity, User.class);
        return userResponse;
    }
}
