package com.lam.game8_3.controller;

import com.lam.game8_3.model.User;
import com.lam.game8_3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Comparator;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/enter-game")
    public String enterGame(HttpSession session, @Param("name") String name) {
        if (!userService.isExistsUser(name)) {
            User newUser = new User();
            newUser.setCurrentLevel(1);
            newUser.setName(name);
            newUser.setScore(0);
            userService.saveUser(newUser);
            session.setAttribute("user", newUser);
        }else  {
            User user = userService.getUserByName(name);
            session.setAttribute("user", user);
        }
        return "redirect:/first-game";
    }

    @PostMapping("/saveDiem")
    public String saveDiem(@Param("id") Integer id, @Param("current_level") int current_level , @Param("score") int score) {
        User user = userService.getUserById(id);
        user.setCurrentLevel(current_level);
        user.setScore(score);
        userService.saveUser(user);
        return "redirect:/leaderboard";
    }

    @GetMapping("/leaderboard")

    public String viewEndGame2(Model model, HttpSession session) {
        List<User> users = userService.findAll();
        users.sort(Comparator.comparing(User::getScore).reversed());
        model.addAttribute("users", users);
        return "competition-board";
    }

}
