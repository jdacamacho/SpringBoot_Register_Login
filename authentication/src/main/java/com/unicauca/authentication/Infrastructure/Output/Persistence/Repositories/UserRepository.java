package com.unicauca.authentication.Infrastructure.Output.Persistence.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unicauca.authentication.Infrastructure.Output.Persistence.Entities.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {
    
}
