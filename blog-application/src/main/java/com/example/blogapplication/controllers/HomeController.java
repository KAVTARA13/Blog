package com.example.blogapplication.controllers;
import com.example.blogapplication.models.TrendsResponse;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

import static com.example.blogapplication.api.GPT.getBlog;
import static com.example.blogapplication.api.GPT.trends;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        TrendsResponse trends = trends();
        System.out.println(Arrays.toString(trends.united_states));
        model.addAttribute("data","Cake is one ");
        return "home";
    }
}
