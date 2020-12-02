package com.rest.cruddemo.errorresponse;

public class ErrorResponseClass {
    private int status;
    private String message;
    private long timnestamp;
    public ErrorResponseClass()
    {

    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimnestamp() {
        return timnestamp;
    }

    public void setTimnestamp(long timnestamp) {
        this.timnestamp = timnestamp;
    }
}
