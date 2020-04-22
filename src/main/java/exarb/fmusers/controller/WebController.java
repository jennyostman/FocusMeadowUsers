package exarb.fmusers.controller;

import exarb.fmusers.exception.RegistrationException;
import exarb.fmusers.model.LoginWeb;
import exarb.fmusers.model.User;
import exarb.fmusers.model.UserWeb;
import exarb.fmusers.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

    private final UserService userService;

    public WebController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/login")
    public String showLoginForm(Model model) {
        LoginWeb loginWeb = new LoginWeb();
        model.addAttribute("loginWeb", loginWeb);
        return "login";
    }

    @PostMapping("/login")
    // Vad ska ligga i ModelAttribute?!
    public String submitLoginForm(@ModelAttribute("user") LoginWeb loginWeb) {
        System.out.println(loginWeb);

        User user = userService.logInUser(loginWeb);
        System.out.println("user från db i controllern: " + user.toString());

        return "focusMeadow";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        UserWeb userWeb = new UserWeb();
        model.addAttribute("userWeb", userWeb);
        return "registration";
    }

    @PostMapping("/register")
    public String submitRegistrationForm(@ModelAttribute("userWeb") UserWeb userWeb, Model model) {
        User user = userService.createNewUser(userWeb);

        // Här behöver vi nog skicka användaren till frontenden sedan?
        // I alla fall id:t.

        LoginWeb loginWeb = new LoginWeb();
        model.addAttribute("loginWeb", loginWeb);
        return "login";
    }

    @ExceptionHandler(RegistrationException.class)
    public ModelAndView handleException(RegistrationException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error/error");
        modelAndView.addObject("message", ex.getMessage());
        return modelAndView;
    }

}