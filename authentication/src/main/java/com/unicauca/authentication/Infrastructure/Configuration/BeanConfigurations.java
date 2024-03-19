package com.unicauca.authentication.Infrastructure.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.unicauca.authentication.Application.Output.ExceptionFormatterIntPort;
import com.unicauca.authentication.Application.Output.ManageUserGatewayIntPort;
import com.unicauca.authentication.Domain.userCases.ManageUserCUImplAdapter;

@Configuration
public class BeanConfigurations {
    
    @Bean
    public ManageUserCUImplAdapter createUserCU(
        ManageUserGatewayIntPort gatewayUser,
        ExceptionFormatterIntPort formatterUser
    ){
        ManageUserCUImplAdapter userCU = new ManageUserCUImplAdapter(gatewayUser,formatterUser);
        return userCU;        
    }
}
