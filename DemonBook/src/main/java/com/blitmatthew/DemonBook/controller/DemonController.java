package com.blitmatthew.DemonBook.controller;

import com.blitmatthew.DemonBook.entity.Demon;
import com.blitmatthew.DemonBook.service.DemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/demon")
public class DemonController {

    @Autowired
    private DemonService demonService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/")
    public String displayAllDemons(Model model) {
        List<Demon> demons = demonService.getAllDemons();
        model.addAttribute("demons", demons);
        return "listOfDemons";
    }

    @GetMapping("/add")
    public String addDemon(Model model) {
        model.addAttribute("demon", new Demon());
        return "addDemon";
    }

    @PostMapping("/add")
    public String addDemon(@ModelAttribute("demon") Demon demon) {
        demonService.saveDemon(demon);
        return "redirect:/demon/";
    }
}
