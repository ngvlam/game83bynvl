package com.lam.game8_3.controller;

import com.lam.game8_3.model.Question;
import com.lam.game8_3.model.User;
import com.lam.game8_3.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import static org.springframework.http.ResponseEntity.ok;

@Controller
public class GameController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/first-game")
    public String viewFirstGame( HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }
        else {
            User user = (User) session.getAttribute("user");
            session.setAttribute("scoreTest", 0);
        }
        return "first-game";
    }

    @GetMapping("/first-game-test-1")
    public String viewFirstGameTestPage1(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }
        else {
            return "first-game-test-1";
        }
    }

    @GetMapping("/first-game-test-2")
    public String viewFirstGameTestPage2(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }
        session.getAttribute("scoreTest");
        return "first-game-test-2";
    }


    @GetMapping("/first-game-test-3")
    public String viewFirstGameTestPage3(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }
        return "first-game-test-3";
    }

    @GetMapping("/first-game-quiz/{id}")
    public String viewQuestion(Model model, HttpSession session, @PathVariable("id") Integer id) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }
        Question q = questionService.getQuestionById(id);
        model.addAttribute("question", q);

        return "first-game-quiz";
    }

    @GetMapping("/end-1")

    public String viewEndGame1(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }

        return "end-game-1";
    }


}
