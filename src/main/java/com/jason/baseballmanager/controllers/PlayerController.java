package com.jason.baseballmanager.controllers;

import com.jason.baseballmanager.models.Player;
import com.jason.baseballmanager.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Controller
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/")
    public String players(Model model) {

        model.addAttribute("allPlayers", playerService.getAll());

        return "players.jsp";
    }

    @GetMapping("/players/new/")
    public String newPlayer(@ModelAttribute("newPlayer") Player newPlayer) {

        return "newPlayer.jsp";
    }

    @PostMapping("/players/create")
    public String createPlayer(@Valid @ModelAttribute("newPlayer") Player newPlayer, BindingResult result) {

        if(result.hasErrors()) {
            return "newPlayer.jsp";
        }

        playerService.create(newPlayer);

        return "redirect:/";
    }

    @GetMapping("/players/{id}")
    public String profile(@PathVariable Long id, Model model) {
        model.addAttribute("player", playerService.getById(id));
            return "profile.jsp";
    }

    //Rendering the update page
    @GetMapping("/players/{id}/edit")
    public String editPlayer(@PathVariable Long id, @ModelAttribute("editPlayer") Player editPlayer, Model model) {
        model.addAttribute("player", playerService.getById(id));

        return "editPlayer.jsp";
    }

    @PutMapping("/players/{id}/update")
    public String updatePlayer(@Valid @ModelAttribute("editPlayer") Player editPlayer, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute(editPlayer);
            return "editPlayer.jsp";
        }

        playerService.update(editPlayer);
        return "redirect:/";
    }

    @DeleteMapping("/players/{id}/destroy")
    public String destroyPlayer(@PathVariable Long id) {

        playerService.deleteById(id);

        return "redirect:/";
    }
}
