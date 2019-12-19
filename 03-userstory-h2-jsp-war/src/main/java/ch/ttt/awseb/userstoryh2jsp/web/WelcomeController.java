package ch.ttt.awseb.userstoryh2jsp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class WelcomeController {

    @GetMapping
    public String showWelcomePage(final ModelMap model, final Principal principal) {
        model.put("name", principal.toString());
        return "welcome";
    }
}
