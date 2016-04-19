package com.mycompany.service.repository;

import com.mycompany.service.entity.Clients;
import org.springframework.data.repository.CrudRepository;

public interface ClientsRepository extends CrudRepository<Clients, Integer>{
    
}
