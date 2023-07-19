package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String show(Model model) {
        model.addAttribute("users", userService.users());
        return "users/all_users";
    }

    @GetMapping("/{id}")
    public String showEach(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "users/each";
    }

    @GetMapping("/new")
    public String create(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping
    public String add(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }
}
