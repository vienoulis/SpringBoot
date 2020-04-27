package crud.dao;

import crud.model.Role;
import crud.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void addUser(User user);

    void delete(long userId);

    User getUserById(Long id);

    public void update(User user);

    void update(long userId, String name, int age, String password);

    Role getRoleByName(String s);

    User getUserByName(String s);

}
