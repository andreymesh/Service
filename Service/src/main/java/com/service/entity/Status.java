package com.service.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table (name="status")
public class Status {
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="id")
    private Integer idStatus;
    
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
    
    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
    
    @Override
    public String toString() {
        return "Status: id="+idStatus+"; status_name="+statusName;
    }
}
