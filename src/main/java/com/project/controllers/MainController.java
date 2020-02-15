package com.project.controllers;

import com.project.db.DBManager;
import com.project.db.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
    private DBManager connection;

    public MainController() {
    }

    @GetMapping(
            path = {"/"}
    )
    public String login(Model model) {
        return "/login";
    }

    @PostMapping(
            path = {"/login"}
    )
    public String loginUser(HttpSession session, @RequestParam("email") String email,
                            @RequestParam("password") String password ) {
       Users user = connection.getUserByLoginAndPassword(email,password);

        if(user!=null){
            session.setAttribute("user", user);
            return "/profile";
        }else {
            return "/login";
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "/login";
    }

}
