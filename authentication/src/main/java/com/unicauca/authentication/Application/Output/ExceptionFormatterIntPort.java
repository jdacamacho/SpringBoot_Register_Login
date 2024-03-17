package com.unicauca.authentication.Application.Output;

public interface ExceptionFormatterIntPort {
    public void returnResponseErrorEntityExists(String message);
    public void returnResponseErrorEntityNotFound(String message);
    public void returnResponseBusinessRuleViolated(String message);
    public void returnResponseBadCredentionales(String message);
    public void retunrResponseBadFormat(String message);
}
