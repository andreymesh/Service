package com.mycompany.service.repository;

import com.mycompany.service.entity.Category;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;


public interface CategoryRepository  extends CrudRepository<Category, Integer>{
        
}
