package com.givehost.web.serviice;

public interface SecurityService {
    boolean isAuthenticated();

    void autoLogin(String email, String password);
}
