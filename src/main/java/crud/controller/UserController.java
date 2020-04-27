package crud.controller;


import crud.model.User;
import crud.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private Service service;

    @GetMapping(value = "/**")
    public String getAll() {
        return "login";
    }

    @GetMapping(value = "user")
    public String getUser(ModelMap map, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        map.addAttribute("user", user);
        return "user";
    }

    @GetMapping(value = "login")
    public String loginPage(ModelMap map) {
        return "login";
    }

}