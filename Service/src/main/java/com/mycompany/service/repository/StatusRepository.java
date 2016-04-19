package com.mycompany.service.repository;

import com.mycompany.service.entity.Status;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<Status,Integer>{
    
}
