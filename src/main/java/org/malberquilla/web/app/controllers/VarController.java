package org.malberquilla.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/var")
public class VarController {

    @GetMapping("/string/{text}/{number}")
    public String var(
        @PathVariable String text,
        @PathVariable Integer number,
        Model model) {

        model.addAttribute("result", "text: " + text + ", number: " + number);
        return "var";
    }
}
