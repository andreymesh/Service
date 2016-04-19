package com.mycompany.service.repository;

import com.mycompany.service.entity.Staff;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;

public interface StaffRepository extends CrudRepository<Staff, Integer>{
    
}
