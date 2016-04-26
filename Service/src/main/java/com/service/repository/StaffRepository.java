package com.service.repository;

import com.service.entity.Staff;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;

public interface StaffRepository extends CrudRepository<Staff, Integer>{
    
}
