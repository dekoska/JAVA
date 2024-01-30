package com.example.frontend.WebController;

import com.example.frontend.Object.RegistrationDTO;
import com.example.frontend.Object.User;
import com.example.frontend.Service.AuthenticationService;
import com.example.frontend.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@CrossOrigin("*")
public class UserWebController {

    private final UserService userService;

    @Autowired
    public UserWebController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping( "/home")
    public String homePage(Model model) {
        return "index";
    }


}
