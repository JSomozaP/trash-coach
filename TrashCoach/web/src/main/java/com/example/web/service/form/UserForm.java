package com.example.web.service.form;

public class UserForm {
    private String text;
    private boolean status;

    public UserForm() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
