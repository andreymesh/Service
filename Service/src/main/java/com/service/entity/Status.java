package com.service.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table (name="status")
public class Status {
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="id")
    private Integer id;
    
    @Column(name ="status_name",nullable = false,length = 45 )
    private String statusName;

    @OneToMany(mappedBy = "status")
    private List <Request> requests;

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
    
    @Override
    public String toString() {
        return "Status: id="+id+"; status_name="+statusName;
    }
}
