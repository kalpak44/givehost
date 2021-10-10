package com.givehost.web.serviice;

import com.givehost.web.model.User;

public interface UserService {
    void save(User user);

    User findByEmail(String email);
}
