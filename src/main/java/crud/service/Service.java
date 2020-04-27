package crud.service;

import crud.model.Role;
import crud.model.User;

import java.util.List;
import java.util.Set;

public interface Service {
    List<User> getUsers();

    void add(User user);

    User getUserById(Long id);

    void updateUser(Long id, User user);

    void delete(String userId);

    User getUserByName(String name);

    Role getRoleByName(String role_admin);
}
