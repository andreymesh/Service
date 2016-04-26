package com.service.entity;

import java.util.Date;
import javax.persistence.*;


@Entity
@Table (name="request")
public class Request {
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="id")
    private Integer idrequest;
    
    @Column (name="short_description")
    private String shortDescription;
    
    @Column (name="description")
    private String description;
    
    @Column (name="warranty")
    private Boolean warranty;
    
    @Column (name="filing_date")
    @Temporal (TemporalType.DATE)
    private Date filingDate;
    
    @Column (name="deadline")
    @Temporal (TemporalType.DATE)
    private Date deadline;
    
    @ManyToOne
    @JoinColumn (name ="idcategory",nullable = false)
    private Category category;
    
    @ManyToOne
    @JoinColumn (name ="idcompany",nullable = false)
    private Company company;
    
    @ManyToOne
    @JoinColumn (name ="idclients",nullable = false)
    private Clients clients;
    
    @ManyToOne
    @JoinColumn (name ="idstatus",nullable = false)
    private Status status;
    
    @ManyToOne
    @JoinColumn (name ="idstaff",nullable = false)
    private Staff staff;

    public Category getCategory() {
        return category;
    }

    public Clients getClients() {
        return clients;
    }

    public Company getCompany() {
        return company;
    }

    public Date getDeadline() {
        return deadline;
    }

    public String getDescription() {
        return description;
    }
    
    public Integer getIdrequest() {
        return idrequest;
    }

    public String getShortDescription() {
        return shortDescription;
    }
    
    public Staff getStaff() {
        return staff;
    }

    public Status getStatus() {
        return status;
    }

    public Boolean getWarranty() {
        return warranty;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getFilingDate() {
        return filingDate;
    }

    public void setFilingDate(Date filingDate) {
        this.filingDate = filingDate;
    }
    
    public void setIdrequest(Integer idrequest) {
        this.idrequest = idrequest;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
    
    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setWarranty(Boolean warranty) {
        this.warranty = warranty;
    }

    @Override
    public String toString() {
        return "Request: id="+idrequest+"; category="+category+
                "; short_description="+shortDescription+"; description="+
                description+";warranty="+warranty+";company="+
                company+"; clients"+clients+"; filing_date="+
                filingDate+"; deadline="+deadline+"; status="+
                status+"; staff="+staff;
    }
    
}
