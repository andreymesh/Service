package com.mycompany.service.repository;

import com.mycompany.service.entity.Company;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Integer>{
    
}
