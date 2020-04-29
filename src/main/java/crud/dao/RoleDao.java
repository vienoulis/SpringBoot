package crud.dao;

import crud.model.Role;

import java.util.List;

public interface RoleDao {

    Role getRoleByName(String s);

    List<Role> getAllRoles();

}
