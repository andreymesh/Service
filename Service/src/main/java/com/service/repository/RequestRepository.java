package com.service.repository;

import com.service.entity.Request;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;

public interface RequestRepository extends CrudRepository<Request,Integer>{
    
}
