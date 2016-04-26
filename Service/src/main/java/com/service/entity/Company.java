package com.service.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="company")
public class Company {
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="id")
    private Integer idcompany;
    
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
    
    public Integer getIdcompany() {
        return idcompany;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }
    
    public void setIdcompany(Integer idcompany) {
        this.idcompany = idcompany;
    }

    @Override
    public String toString() {
        return "Company: id="+idcompany+"; company_name="+companyName;
    }
}
