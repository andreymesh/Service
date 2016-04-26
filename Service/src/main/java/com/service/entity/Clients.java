package com.service.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="clients")
public class Clients {
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="id")
    private Integer idClients;
    
    @Column(name="FIO",nullable = false,length = 80)
    private String fio;
    
    @Column (name="telephone",nullable = false,length = 45)
    private String telephone;

    @OneToMany (mappedBy = "clients")
    private List <Request> requests;

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }
     
    public String getFio() {
        return fio;
    }

    public Integer getIdClients() {
        return idClients;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setIdClients(Integer idClients) {
        this.idClients = idClients;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Clients: id="+idClients+"; FIO="+fio+"; telephone="+telephone;
    }
}
