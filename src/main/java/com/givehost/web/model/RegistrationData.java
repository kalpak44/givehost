package com.givehost.web.model;

public class RegistrationData {
    private String names;
    private String email;
    private String password;

    public String getNames() {
        return names;
    }

    public RegistrationData setNames(String names) {
        this.names = names;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegistrationData setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegistrationData setPassword(String password) {
        this.password = password;
        return this;
    }
}
