package crud.service;

import crud.dao.RoleDao;
import crud.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    private RoleDao dao;

    @Override
    @Transactional
    public Role getRoleByName(String role) {
        return dao.getRoleByName(role);
    }

    @Override
    @Transactional
    public List<Role> getAllRoles() {
        return dao.getAllRoles();
    }
}
