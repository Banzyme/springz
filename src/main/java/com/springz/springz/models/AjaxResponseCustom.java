package com.springz.springz.models;

public class AjaxResponseCustom {
    private boolean succeeded;
    private String message;

    public boolean isSucceeded() {
        return succeeded;
    }

    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AjaxResponseCustom(boolean success, String msg) {
        this.succeeded = success;
        this.message = msg;
    }

    public AjaxResponseCustom() {
        this.succeeded = true;
        this.message = "Process completed.";

    }
}
