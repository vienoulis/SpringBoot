package crud.service;

import crud.dao.UserDao;
import crud.model.Role;
import crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ServiceImp implements Service, UserDetailsService {

    @Autowired
    private UserDao dao;

    @Transactional(readOnly = true)
    public List<User> getUsers() {
        return dao.getAllUsers();
    }

    @Override
    @Transactional
    public void add(User user) {
        dao.addUser(user);
    }

    @Transactional
    public User getUserById(Long id) {
        return dao.getUserById(id);
    }

    @Override
    @Transactional
    public Role getRoleByName(String role) {
        return dao.getRoleByName(role);
    }

    @Override
    @Transactional
    public void updateUser (Long id, User user){
        user.setId(id);
        dao.update(user);
    }



    @Transactional
    public void delete(String userId) {
        if (userId.matches("[0-9]+")) {
            dao.delete(Long.parseLong(userId));
        }
    }

    @Transactional
    @Override
    public User getUserByName(String name) {
        return dao.getUserByName(name);
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getUserByName(username);
    }
}
