package crud.controller;

import crud.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin/delete")

public class DeleteController {
    @Autowired
    private Service service;

    @PostMapping
    public String postDelete(HttpServletRequest request, ModelMap map) {
        service.delete(request.getParameter("userId"));
        map.addAttribute("users", service.getUsers());

        return "admin";
    }
}
