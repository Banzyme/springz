package com.springz.springz.models;

public class AjaxResponseCustom {
    private boolean succeeded;
    private String message;

    public AjaxResponseCustom(boolean success, String msg) {
        this.succeeded = success;
        this.message = msg;
    }

    public AjaxResponseCustom() {
        this.succeeded = true;
        this.message = "Process completed.";

    }
}
