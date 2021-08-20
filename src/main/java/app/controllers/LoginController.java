package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class LoginController {

   /* @GetMapping("/hello")
    public String getHelloPage() {
        return "hello";
    }*/

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}