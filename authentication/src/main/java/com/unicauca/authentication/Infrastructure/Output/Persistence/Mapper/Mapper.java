package com.unicauca.authentication.Infrastructure.Output.Persistence.Mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.unicauca.authentication.Domain.Models.Credential;
import com.unicauca.authentication.Infrastructure.Output.Persistence.Entities.CredentialEntity;

@Configuration
public class Mapper {
    @Bean
    public ModelMapper createMapper(){
        ModelMapper mapper = new ModelMapper();
        
        TypeMap<CredentialEntity,Credential> mapCredential = mapper.emptyTypeMap(CredentialEntity.class, Credential.class);
        mapCredential.addMappings(m -> m.skip(Credential::setObjUser)).implicitMappings();

        return mapper;
    }
}
