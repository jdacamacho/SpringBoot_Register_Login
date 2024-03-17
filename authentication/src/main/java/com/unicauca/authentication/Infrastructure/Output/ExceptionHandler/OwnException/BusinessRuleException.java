package com.unicauca.authentication.Infrastructure.Output.ExceptionHandler.OwnException;

import com.unicauca.authentication.Infrastructure.Output.ExceptionHandler.ExceptionStructure.ErrorCode;

public class BusinessRuleException extends ManageRunTimeException{
    private static final String EXCEPTION_FORMAT = "%s - Business rule violation: %s";
    private final String businessRule;

    public BusinessRuleException(final String businessRule){
        super(ErrorCode.BUSINESS_RULE_VIOLATION);
        this.businessRule = businessRule;
    }

    @Override
    public String formatException() {
        return String.format(EXCEPTION_FORMAT, errorCode.getCode(), businessRule);
    }
}
