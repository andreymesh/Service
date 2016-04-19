package com.mycompany.service.controller;

import com.mycompany.service.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
    @Autowired
    CategoryRepository categoryRepository;
    
    @RequestMapping (value = "/",method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("category",categoryRepository.findAll());
        return "index";
    }
}
