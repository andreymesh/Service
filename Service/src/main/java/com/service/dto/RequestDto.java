package com.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.service.entity.Category;
import java.util.Date;


public class RequestDto {
    @JsonProperty
    private String shortDescription;
    @JsonProperty
    private String description;
    @JsonProperty
    private Boolean warranty;
    @JsonProperty
    private Integer categoryId;
    @JsonProperty
    private Integer companyId;
    @JsonProperty
    private String clients;
    @JsonProperty
    private String telephone;
    @JsonProperty
    private Integer statusId;
    @JsonProperty
    private Integer staffId;

    public Integer getCategoryId() {
        return categoryId;
    }
    public Integer getCompanyId() {
        return companyId;
    }

    public String getDescription() {
        return description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public Boolean getWarranty() {
        return warranty;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getClients() {
        return clients;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setClients(String clients) {
        this.clients = clients;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public void setWarranty(Boolean warranty) {
        this.warranty = warranty;
    }
}
