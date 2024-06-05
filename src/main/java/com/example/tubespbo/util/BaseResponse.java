package com.example.tubespbo.util;

public class BaseResponse<T> {
    private T data;
    private String message;
    private String code;

    public BaseResponse() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setSuccess(boolean success) {
        if (success) {
            this.code = "SUCCESS";
            this.message = "Operation successful";
        } else {
            this.code = "ERROR";
            this.message = "Operation failed";
        }
    }
    
}
