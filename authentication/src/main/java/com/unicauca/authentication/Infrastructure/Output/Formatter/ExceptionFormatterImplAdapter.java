package com.unicauca.authentication.Infrastructure.Output.Formatter;

import org.springframework.stereotype.Service;

import com.unicauca.authentication.Application.Output.ExceptionFormatterIntPort;
import com.unicauca.authentication.Infrastructure.Output.ExceptionHandler.OwnException.BadCredentionalsException;
import com.unicauca.authentication.Infrastructure.Output.ExceptionHandler.OwnException.BadFormatException;
import com.unicauca.authentication.Infrastructure.Output.ExceptionHandler.OwnException.BusinessRuleException;
import com.unicauca.authentication.Infrastructure.Output.ExceptionHandler.OwnException.EntityExistsException;
import com.unicauca.authentication.Infrastructure.Output.ExceptionHandler.OwnException.EntityNotFoundException;

@Service
public class ExceptionFormatterImplAdapter implements ExceptionFormatterIntPort{

    @Override
    public void returnResponseErrorEntityExists(String message) {
        EntityExistsException objException = new EntityExistsException(message);
        throw objException;
    }

    @Override
    public void returnResponseErrorEntityNotFound(String message) {
        EntityNotFoundException objException = new EntityNotFoundException(message);
        throw objException;
    }

    @Override
    public void returnResponseBusinessRuleViolated(String message) {
        BusinessRuleException objException = new BusinessRuleException(message);
        throw objException;
    }

    @Override
    public void returnResponseBadCredentionales(String message) {
        BadCredentionalsException objException = new BadCredentionalsException(message);
        throw objException;
    }

    @Override
    public void retunrResponseBadFormat(String message) {
        BadFormatException objException = new BadFormatException(message);
        throw objException;
    } 
}
