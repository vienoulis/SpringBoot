package crud.service;

import crud.model.Role;

import java.util.List;

public interface RoleService {

    Role getRoleByName(String role_admin);

    List<Role> getAllRoles();
}
