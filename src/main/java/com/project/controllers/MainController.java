package com.project.controllers;

import com.project.db.DBManager;
import com.project.db.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class MainController {

    @Autowired
    private DBManager connection;

    public MainController() {
    }

    @GetMapping(
            path = {"/"}
    )
    public String index(Model model) {
//        ArrayList<Users> books = this.connection.getAllBooks();
//        model.addAttribute("books", books);
        return "/login";
    }
//    @GetMapping(
//            path = {"/listbook"}
//    )
//    public String listbook(Model model) {
//        ArrayList<Books> books = this.connection.getAllBooks();
//        model.addAttribute("books", books);
//        return "/listbook";
//    }
    @PostMapping(
            path = {"/auth"}
    )
    public String loginUser(Model model, @RequestParam("email") String email,
                             @RequestParam("password") String password
                             ) {
        Users user = null;
        if(email!=null&&!email.equals("")&&password!=null&&!password.equals("")){

            user = connection.getUserByLoginAndPassword(email,password);

            if(user!=null){
                model.addAttribute("user", user);
            }else {
                return "/login";
            }

        }
        return "/profile";
    }

    @GetMapping(
            path = {"/addbook"}
    )
    public String addBlog(Model model) {
        return "/addbook";
    }

//    @PostMapping(
//            path = {"/addbook"}
//    )
//    public String toAddBlog(@RequestParam("name") String name, @RequestParam("author") String author, @RequestParam("price") int price) {
//        Books b = new Books((Long)null, name, author, price);
//        return this.connection.addBooks(b) ? "redirect:addbook?success" : "redirect:addbook?error";
//    }
//
//    @GetMapping(
//            path = {"/readblog/{id}/{latinUrl}.html"}
//    )
//    public String readBlog(Model model, @PathVariable("id") Long id, @PathVariable("latinUrl") String latinUrl) {
//        Books books = this.connection.getBook(id);
//        model.addAttribute("book", books);
//        return "/readblog";
//    }
}
