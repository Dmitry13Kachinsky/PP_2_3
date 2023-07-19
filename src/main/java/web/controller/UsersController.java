package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String show(@RequestParam(defaultValue = "5") int count, Model model) {
        model.addAttribute("users", userService.users(count));
        return "users/all_users";
    }

    @GetMapping("/{id}")
    public String showEach(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "users/each";
    }
}
