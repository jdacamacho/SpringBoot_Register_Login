package com.unicauca.authentication.Infrastructure.Output.ExceptionHandler.OwnException;

@Getter
public class BadFormatException extends RuntimeException{
    private final String mesageKey;
    private final String code;

    public BadFormatException(ErrorCode code){
        super(code.getCode());
        this.mesageKey = code.getMessageKey();
        this.code = code.getCode();
    }

    public BadFormatException(final String message){
        super(message);
        this.mesageKey = ErrorCode.BAD_FORMAT.getCode();
        this.code = ErrorCode.BAD_FORMAT.getCode();
    }
}
