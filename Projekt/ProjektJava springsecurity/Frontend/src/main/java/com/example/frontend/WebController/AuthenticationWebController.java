package com.example.frontend.WebController;

import com.example.frontend.Object.RegistrationDTO;
import com.example.frontend.Object.User;
import com.example.frontend.Service.AuthenticationService;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
@CrossOrigin("*")
public class AuthenticationWebController {

    @Autowired
    private final AuthenticationService authenticationService;

    public AuthenticationWebController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/register")
    public String registerView(Model model){
        model.addAttribute("user",new User());
        return "register";
    }

    @PostMapping("/register")
    public void registerUser(Model model, RegistrationDTO body, HttpServletResponse httpServletResponse) throws IOException {
        model.addAttribute("user", authenticationService.registerUser(body.getUsername(), body.getPassword(), body.getEmail()));
        httpServletResponse.sendRedirect("http://localhost:8081/login");
    }

    @GetMapping("/login")
    public String loginView(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public void loginUser(Model model, RegistrationDTO body, HttpServletResponse httpServletResponse) throws IOException {
        model.addAttribute("user", authenticationService.loginUser(body.getUsername(), body.getPassword()));
        httpServletResponse.sendRedirect("http://localhost:8081/home");
    }

}
