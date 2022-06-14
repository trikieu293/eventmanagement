package controllers;

import dto.HomeEventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import services.HomeService;

import java.util.List;

@Controller
public class MainController {

    private final HomeService homeService;

    @Autowired
    public MainController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping(value = {"/home", "", "/"})
    public String home(Model model) {
        List<HomeEventDTO> listEvent = homeService.findAll();
        model.addAttribute("listEvent", listEvent);
        return "home.html";
    }
}
