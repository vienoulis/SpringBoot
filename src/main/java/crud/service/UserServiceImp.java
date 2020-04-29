package crud.service;

import crud.dao.UserDao;
import crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserServiceImp implements UserService, UserDetailsService {

    @Autowired
    private UserDao dao;

    @Override
    @Transactional(readOnly = true)
    public List<User> getUsers() {
        return dao.getAllUsers();
    }

    @Override
    @Transactional
    public void add(User user) {
        dao.addUser(user);
    }



    @Override
    @Transactional
    public User getUserById(Long id) {
        return dao.getUserById(id);
    }


    @Override
    @Transactional
    public void updateUser (User user){
        dao.update(user);
    }

    @Override
    @Transactional
    public void delete(String userId) {
        if (userId.matches("[0-9]+")) {
            dao.delete(Long.parseLong(userId));
        }
    }

    @Override
    @Transactional
    public User getUserByName(String name) {
        return dao.getUserByName(name);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getUserByName(username);
    }
}
