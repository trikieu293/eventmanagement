package com.uni.eventmanagement.controllers;

import com.uni.eventmanagement.dto.HomeEventDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.uni.eventmanagement.services.HomeService;

import java.util.List;

@Slf4j
@Controller
public class MainController {

    private final HomeService homeService;

    @Autowired
    public MainController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping(value = {"home", "", "/"})
    String home(Model model) {
        log.info("started");
        List<HomeEventDTO> listEvent = homeService.findAll();
        List<HomeEventDTO> upcomingList = homeService.getUpcomingList();
        List<HomeEventDTO> sidebarList = homeService.getSidebarList();
        model.addAttribute("listEvent", listEvent);
        model.addAttribute("upcomingList", upcomingList);
        model.addAttribute("sidebarList", sidebarList);
        return "home";
    }
}
