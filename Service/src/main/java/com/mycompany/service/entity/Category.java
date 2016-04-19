package com.mycompany.service.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="category")
public class Category {
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="idcategory")
    private Integer idcategory;
    
    @Column(name="category_name",length = 80,nullable = false)
    private String category;
    
    @OneToMany (mappedBy ="category")
    private List <Request> requests;

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }
        
    public String getCategory() {
        return category;
    }

    public Integer getIdcategory() {
        return idcategory;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setIdcategory(Integer idcategory) {
        this.idcategory = idcategory;
    }

    @Override
    public String toString() {
        return "Category: id="+idcategory+"; category="+category;
    }
    
    
}
