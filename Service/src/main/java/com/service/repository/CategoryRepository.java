package com.service.repository;

import com.service.entity.Category;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;


public interface CategoryRepository  extends CrudRepository<Category, Integer>{
        
}
