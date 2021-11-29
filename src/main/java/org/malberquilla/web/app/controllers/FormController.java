package org.malberquilla.web.app.controllers;

import javax.validation.Valid;
import org.malberquilla.web.app.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("user")
public class FormController {

    @GetMapping("/form")
    public String form(Model model) {
        var user = new User();
        user.setName("Mario");
        user.setLastName("Alberquilla");
        user.setId(1);
        model.addAttribute("user", user);
        return "form";
    }

    @PostMapping("/form")
    public String save(@Valid User user, BindingResult result, Model model, SessionStatus status) {

        if (result.hasErrors()) {

            return "form";
        }

        model.addAttribute("user", user);
        status.setComplete();

        return "result";
    }
}
