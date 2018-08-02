package com.itecheasy.core;

/**
 * @Auther: liteng
 * @Date: 2018/7/20 17:48
 * @Description:
 */
public class CallOsmsAmException extends RuntimeException {

    private String errorCode;

    private String errorData;

    public CallOsmsAmException(String errorCode) {
       super(errorCode);
       this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorData() {
        return errorData;
    }

    public void setErrorData(String errorData) {
        this.errorData = errorData;
    }
}
