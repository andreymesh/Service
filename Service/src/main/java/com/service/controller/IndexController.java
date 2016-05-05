package com.service.controller;

import com.service.repository.CategoryRepository;
import com.service.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
    @Autowired
    RequestRepository requestRepository;
    
    @RequestMapping (value = "/",method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("requests",requestRepository.findAll());
        return "index";
    }
}
