package crud.service;

import crud.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    void add(User user);

    void updateUser( User user);

    void delete(String userId);

    User getUserByName(String name);

    User getUserById(Long id);
}
