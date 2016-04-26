package com.service.controller;

import com.service.repository.CategoryRepository;
import com.service.repository.RequestRepository;
import com.service.repository.StaffRepository;
import com.service.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestController {
    @Autowired
    CategoryRepository categoryRepository;
    
    @Autowired
    StaffRepository staffRepository;
    
    @Autowired
    StatusRepository statusRepository;
    
    @Autowired
    RequestRepository requestRepository;
    
    @RequestMapping (value = "/form",method = RequestMethod.GET)
    public String form (Model model,
            @RequestParam (required = false, value = "requestId") Integer requestId)
    {
        model.addAttribute("categorys",categoryRepository.findAll());
        model.addAttribute("staff", staffRepository.findAll());
        model.addAttribute("status", statusRepository.findAll());
        if (requestId!=null){
            model.addAttribute("req",requestRepository.findOne(requestId));
        }        
        return "form";                
    }
}
