package com.mycompany.service.test;

import com.mycompany.service.config.DataConfig;
import com.mycompany.service.config.DataSourceConfig;
import com.mycompany.service.entity.*;
import com.mycompany.service.repository.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration (classes={DataConfig.class,DataSourceConfig.class},
        loader = AnnotationConfigContextLoader.class)
public class DBtest {
    
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ClientsRepository clientsRepository;
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    StaffRepository staffRepository;
    @Autowired
    StatusRepository statusRepository;
    @Autowired
    RequestRepository requestRepository;
    
    @Test
    public void findAllTest1()
    {
        Iterable <Clients> temp=clientsRepository.findAll();
        temp.forEach(c -> System.out.println(c));
    }
    
    @Test
    public void findAllTest2()
    {
        Iterable<Category>temp= categoryRepository.findAll();
        temp.forEach(c -> System.out.println(c));
        Assert.assertNotNull(temp);
    }
    
    @Test
    public void findAllTest3()
    {
        Iterable <Company> temp=companyRepository.findAll();
        temp.forEach(c -> System.out.println(c));
    }
    
    @Test
    public void findAllTest4()
    {
        Iterable <Staff> temp=staffRepository.findAll();
        temp.forEach(c -> System.out.println(c));
    }
    
    @Test
    public void findAllTest5()
    {
        Iterable <Status> temp=statusRepository.findAll();
        temp.forEach(c -> System.out.println(c));
    }
    
    @Test
    public void findAllTest6()
    {
        Iterable <Request> temp=requestRepository.findAll();
        temp.forEach(c -> System.out.println(c));
    }
}
