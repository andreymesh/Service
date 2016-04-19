package com.mycompany.service.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="staff")
public class Staff {
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="idstaff")
    private Integer idstaff;
    
    @Column(name="FIO",nullable = false,length = 80)
    private String fio;
    
    @OneToMany(mappedBy = "staff")
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

    public Integer getIdstaff() {
        return idstaff;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setIdstaff(Integer idstaff) {
        this.idstaff = idstaff;
    }

    @Override
    public String toString() {
        return "Staff: id="+idstaff+"; FIO="+fio;
    }
}
