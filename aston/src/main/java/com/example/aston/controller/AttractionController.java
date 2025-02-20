package com.example.aston.controller;

import com.example.aston.model.Attraction;
import com.example.aston.model.AttractionType;
import com.example.aston.service.AttractionService;
import com.example.aston.service.AddressService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/attractions")
public class AttractionController {

    private final AttractionService attractionService;


    private final AddressService addressService;

    public AttractionController(AttractionService attractionService, AddressService addressService) {
        this.attractionService = attractionService;
        this.addressService = addressService;
    }

    @GetMapping
    public String getAllAttractions(Model model) {
        model.addAttribute("attractions", attractionService.getAllAttractions());
        return "attractions";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("attraction", new Attraction());
        model.addAttribute("addresses", addressService.getAllAddresses());
        return "attraction-form";
    }

    @PostMapping("/add")
    public String addAttraction(@ModelAttribute Attraction attraction) {
        attractionService.saveAttraction(attraction);
        return "redirect:/attractions";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Attraction attraction = attractionService.getAttractionById(id);
        model.addAttribute("attraction", attraction);
        model.addAttribute("addresses", addressService.getAllAddresses());
        return "attraction-form";
    }

    @PostMapping("/edit/{id}")
    public String updateAttraction(@PathVariable Long id, @ModelAttribute Attraction attraction) {
        attraction.setId(id);
        attractionService.saveAttraction(attraction);
        return "redirect:/attractions";
    }

    @GetMapping("/delete/{id}")
    public String deleteAttraction(@PathVariable Long id) {
        attractionService.deleteAttraction(id);
        return "redirect:/attractions";
    }

    @ModelAttribute("attractionTypes")
    public AttractionType[] getAttractionTypes() {
        return AttractionType.values();
    }
}