package com.mycompany.service.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="company")
public class Company {
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="idcompany")
    private Integer idcompany;
    
    @Column (name = "company_name",nullable = false,length = 60)
    private String company_name;

    @OneToMany(mappedBy = "company")
    private List <Request> requests;

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }
        
    public String getCompany_name() {
        return company_name;
    }

    public Integer getIdcompany() {
        return idcompany;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public void setIdcompany(Integer idcompany) {
        this.idcompany = idcompany;
    }

    @Override
    public String toString() {
        return "Company: id="+idcompany+"; company_name="+company_name;
    }
    
}
