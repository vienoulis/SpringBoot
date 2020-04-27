package crud.controller;

import crud.model.Role;
import crud.model.User;
import crud.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin/user")
public class AdminController {

    @Autowired
    private Service service;


    @GetMapping()
    public String getUser(ModelMap map) {
        List<User> users = service.getUsers();
        map.addAttribute("users", users);

        return "admin";
    }

    @PostMapping()
    public String postUser(HttpServletRequest request, ModelMap map, User user, String role_admin, String role_user) {
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(service.getRoleByName(role_admin));
        roleSet.add(service.getRoleByName(role_user));
        user.setRoleSet(roleSet);
        service.add(user);
        List<User> users = service.getUsers();
        map.addAttribute("users", users);

        return "admin";
    }
}
