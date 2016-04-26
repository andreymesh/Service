package com.service.repository;

import com.service.entity.Clients;
import org.springframework.data.repository.CrudRepository;

public interface ClientsRepository extends CrudRepository<Clients, Integer>{
    
}
