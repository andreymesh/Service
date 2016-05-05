package com.service.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="category")
public class Category {
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="id")
    private Integer id;
    
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Category: id="+id+"; category="+category;
    }
}
