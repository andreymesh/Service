package com.mycompany.service.entity;

import java.util.Date;
import javax.persistence.*;


@Entity
@Table (name="request")
public class Request {
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="idrequest")
    private Integer idrequest;
    
    @Column (name="short_description")
    private String short_description;
    
    @Column (name="description")
    private String description;
    
    @Column (name="warranty")
    private Boolean warranty;
    
    @Column (name="filing_date")
    @Temporal (TemporalType.DATE)
    private Date filing_date;
    
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

    public Date getFiling_date() {
        return filing_date;
    }

    public Integer getIdrequest() {
        return idrequest;
    }

    public String getShort_description() {
        return short_description;
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

    public void setFiling_date(Date filing_date) {
        this.filing_date = filing_date;
    }

    public void setIdrequest(Integer idrequest) {
        this.idrequest = idrequest;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
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
                "; short_description="+short_description+"; description="+
                description+";warranty="+warranty+";company="+
                company+"; clients"+clients+"; filing_date="+
                filing_date+"; deadline="+deadline+"; status="+
                status+"; staff="+staff;
    }
    
}
