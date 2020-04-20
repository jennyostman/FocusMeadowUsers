package exarb.fmusers.controller;

import exarb.fmusers.model.LoginWeb;
import exarb.fmusers.model.UserWeb;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class WebController {

    @GetMapping(value = "/login")
    public String login(Model model) {
        LoginWeb loginWeb = new LoginWeb();
        model.addAttribute("loginWeb", loginWeb);
        return "login";
    }

    @PostMapping("/login")
    public String submitLoginForm(@ModelAttribute("user") LoginWeb loginWeb) {
        System.out.println(loginWeb);
        return "focusMeadow";
    }

    @GetMapping("/register")
    public String showForm(Model model) {
        UserWeb userWeb = new UserWeb();
        model.addAttribute("userWeb", userWeb);
        return "registration";
    }

    @PostMapping("/register")
    public String submitRegistrationForm(@ModelAttribute("user") UserWeb userWeb, Model model) {
        System.out.println(userWeb);

        LoginWeb loginWeb = new LoginWeb();
        model.addAttribute("loginWeb", loginWeb);
        return "login";
    }


}