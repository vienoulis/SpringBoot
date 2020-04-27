package crud.controller;

import crud.model.Role;
import crud.model.User;
import crud.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

@Controller
public class UpdateController {

    @Autowired
    private Service service;

    @GetMapping("/admin/update")
    public String getUpdate(Long userId, ModelMap map) {
        User user = service.getUserById(userId);
        map.addAttribute("userUpdated", user);

        return "update";
    }

    @PostMapping("/admin/update")
    public String postUpdate(Long userId, ModelMap map, User user, String role_user, String role_admin) {
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(service.getRoleByName(role_admin));
        roleSet.add(service.getRoleByName(role_user));
        user.setRoleSet(roleSet);
        service.updateUser(userId, user);
        map.addAttribute("users", service.getUsers());

        return "admin";
    }
}
