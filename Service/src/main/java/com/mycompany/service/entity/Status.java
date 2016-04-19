package com.mycompany.service.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table (name="status")
public class Status {
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="idstatus")
    private Integer id_status;
    
    @Column(name ="status_name",nullable = false,length = 45 )
    private String status_name;

    @OneToMany(mappedBy = "status")
    private List <Request> requests;

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }
    
    public Integer getId_status() {
        return id_status;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setId_status(Integer id_status) {
        this.id_status = id_status;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }

    @Override
    public String toString() {
        return "Status: id="+id_status+"; status_name="+status_name;
    }
    
}
