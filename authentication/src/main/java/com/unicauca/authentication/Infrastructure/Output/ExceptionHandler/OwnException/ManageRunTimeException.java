package com.unicauca.authentication.Infrastructure.Output.ExceptionHandler.OwnException;

import com.unicauca.authentication.Infrastructure.Output.ExceptionHandler.ExceptionStructure.ErrorCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class ManageRunTimeException extends RuntimeException{
    protected ErrorCode errorCode;

    public abstract String formatException();
}
