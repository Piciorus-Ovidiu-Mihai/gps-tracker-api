package org.scd.config.exception;

public class BusinessException extends Exception{
    public Integer status;

    public BusinessException(Integer status, String message) {
        super(message);
        this.status=status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
