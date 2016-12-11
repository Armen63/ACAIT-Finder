package am.aca.springsecurityapp.service;

import am.aca.springsecurityapp.model.User;



public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
