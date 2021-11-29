package org.malberquilla.web.app.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsController {

    @GetMapping("/string")
    public String param(@RequestParam String text, Model model) {
        model.addAttribute("result", "Sent text is: " + text);
        return "params/ver";
    }

    @GetMapping("/mix-params")
    public String param(HttpServletRequest request, Model model) {
        String text = request.getParameter("text");
        Integer number = Integer.parseInt(request.getParameter("number"));

        model.addAttribute("result", "Text: " + text + ", Number: " + number);

        return "params/ver";
    }
}
