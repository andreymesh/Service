package com.service.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="company")
public class Company {
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="id")
    private Integer id;
    
    @Column (name = "company_name",nullable = false,length = 60)
    private String companyName;

    @OneToMany(mappedBy = "company")
    private List <Request> requests;

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }
    

    @Override
    public String toString() {
        return "Company: id="+id+"; company_name="+companyName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
