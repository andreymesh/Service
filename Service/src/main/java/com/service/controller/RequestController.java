package com.service.controller;

import com.service.dto.*;
import com.service.entity.*;
import com.service.repository.*;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    
    @Autowired
    ClientsRepository clientsRepository;
    
    @Autowired
    CompanyRepository companyRepository;
    
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
    
    @RequestMapping (value = "/requests",method = RequestMethod.DELETE)
    public void deleteRequest(@RequestParam (required = false, value = "requestId") Integer requestId,
            HttpServletResponse response) throws IOException
    {
        if (requestRepository.findOne(requestId)!=null)
        {
            requestRepository.delete(requestId);   
        }
        else
        {
           response.sendError(404);
        }
    }
    
    @RequestMapping (value = "/requests/{requestId}",method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public MessageDto updateRequest(@PathVariable ("requestId") Integer requestId,
            @RequestBody  RequestDto dto,HttpServletResponse response) throws IOException
    {
        Request request=requestRepository.findOne(requestId);
        if (request!=null)
        {
            if (!dto.getCategoryId().equals(request.getCategory().getId())){
                Category category=categoryRepository.findOne(dto.getCategoryId());
                if (category!=null)
                {
                    request.setCategory(category);
                }
                else
                {
                    response.sendError(404);
                }
            }
            Clients clients=request.getClients();
            clients.setFio(dto.getClients());
            clients.setTelephone(dto.getTelephone());
            clientsRepository.save(clients);
            if (!dto.getCompanyId().equals(request.getCompany().getId()))
            {
                Company company=companyRepository.findOne(dto.getCompanyId());
                if (company!=null)
                {
                    request.setCompany(company);
                }
                else
                {
                    response.sendError(404);
                }
            }
            if (!dto.getStaffId().equals(request.getStaff().getId()))
            {
                Staff staff=staffRepository.findOne(dto.getStaffId());
                if (staff!=null)
                {
                    request.setStaff(staff);
                }
                else
                {
                    response.sendError(404);
                }
            }
            if (!dto.getStatusId().equals(request.getStatus().getId()))
            {
                Status status=statusRepository.findOne(dto.getStatusId());
                if (status!=null)
                {
                    request.setStatus(status);
                }
                else
                {
                    response.sendError(404);
                }
            }
            request.setDescription(dto.getDescription());
            request.setShortDescription(dto.getShortDescription());
            request.setWarranty(dto.getWarranty());
            requestRepository.save(request);
            MessageDto messageDto=new MessageDto("обновление прошло успешно");
            return messageDto;
        }
        else
        {
            response.sendError(404);
        }
        return null;
    }
    
    @RequestMapping (value = "/requests",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public MessageDto insertRequest(@RequestBody  RequestDto dto,
            HttpServletResponse response) throws IOException
    {
        Request request=new Request();
        Date date=new Date();
            Category category=categoryRepository.findOne(dto.getCategoryId());
            if (category!=null)
            {
                request.setCategory(category);
            }
            else
            {
                response.sendError(404);
                return null;
            }
            Company company=companyRepository.findOne(dto.getCompanyId());
            if (company!=null)
            {
                request.setCompany(company);
            }
            else
            {
                response.sendError(404);
                return null;
            }
            Staff staff=staffRepository.findOne(dto.getStaffId());
            if (staff!=null)
            {
                request.setStaff(staff);
            }
            else
            {
                response.sendError(404);
                return null;
            }
            Status status=statusRepository.findOne(dto.getStatusId());
            if (status!=null)
            {
                request.setStatus(status);
            }
            else
            {
                response.sendError(404);
                return null;
            }
            Clients clients=request.getClients();
            clients.setFio(dto.getClients());
            clients.setTelephone(dto.getTelephone());
            clientsRepository.save(clients);
            request.setDescription(dto.getDescription());
            request.setShortDescription(dto.getShortDescription());
            request.setWarranty(dto.getWarranty());
            request.setFilingDate(date);
            request.setDeadline(new Date(date.toInstant().plus(21, ChronoUnit.DAYS).toEpochMilli()));
            requestRepository.save(request);
            MessageDto messageDto=new MessageDto("добавление прошло успешно");
            return messageDto;
    }
}
