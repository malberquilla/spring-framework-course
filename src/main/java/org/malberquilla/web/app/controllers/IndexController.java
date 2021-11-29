package org.malberquilla.web.app.controllers;

import org.malberquilla.web.app.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class IndexController {

    @Value("${index.title}")
    private String title;

    @GetMapping({"/"})
    public String index(Model model) {
        model.addAttribute("titulo", title);

        var user = new User("Mario", 36);
        user.setEmail("malberquilla@gmail.com");
        model.addAttribute("user", user);
        return "index";
    }
}
