/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sruthi
 */
@Entity
@Table(name = "taxistand")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Taxistand.findAll", query = "SELECT t FROM Taxistand t"),
    @NamedQuery(name = "Taxistand.findByTaxiStandId", query = "SELECT t FROM Taxistand t WHERE t.taxiStandId = :taxiStandId"),
    @NamedQuery(name = "Taxistand.findByTaxiStandCode", query = "SELECT t FROM Taxistand t WHERE t.taxiStandCode = :taxiStandCode"),
    @NamedQuery(name = "Taxistand.findByTaxiStandName", query = "SELECT t FROM Taxistand t WHERE t.taxiStandName = :taxiStandName"),
    @NamedQuery(name = "Taxistand.findByLatitude", query = "SELECT t FROM Taxistand t WHERE t.latitude = :latitude"),
    @NamedQuery(name = "Taxistand.findByLongitude", query = "SELECT t FROM Taxistand t WHERE t.longitude = :longitude"),
    @NamedQuery(name = "Taxistand.findByPeopleQueueCount", query = "SELECT t FROM Taxistand t WHERE t.peopleQueueCount = :peopleQueueCount"),
    @NamedQuery(name = "Taxistand.findByExpectedWaitTime", query = "SELECT t FROM Taxistand t WHERE t.expectedWaitTime = :expectedWaitTime"),
    @NamedQuery(name = "Taxistand.findByStatus", query = "SELECT t FROM Taxistand t WHERE t.status = :status"),
    @NamedQuery(name = "Taxistand.findByLastrun", query = "SELECT t FROM Taxistand t WHERE t.lastrun = :lastrun")})
public class Taxistand implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "taxiStandId")
    private Integer taxiStandId;
    @Size(max = 45)
    @Column(name = "taxiStandCode")
    private String taxiStandCode;
    @Size(max = 45)
    @Column(name = "taxiStandName")
    private String taxiStandName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "peopleQueueCount")
    private Integer peopleQueueCount;
    @Size(max = 45)
    @Column(name = "expectedWaitTime")
    private String expectedWaitTime;
    @Column(name = "status")
    private Integer status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lastrun")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastrun;

    public Taxistand() {
    }

    public Taxistand(Integer taxiStandId) {
        this.taxiStandId = taxiStandId;
    }

    public Taxistand(Integer taxiStandId, Date lastrun) {
        this.taxiStandId = taxiStandId;
        this.lastrun = lastrun;
    }

    public Integer getTaxiStandId() {
        return taxiStandId;
    }

    public void setTaxiStandId(Integer taxiStandId) {
        this.taxiStandId = taxiStandId;
    }

    public String getTaxiStandCode() {
        return taxiStandCode;
    }

    public void setTaxiStandCode(String taxiStandCode) {
        this.taxiStandCode = taxiStandCode;
    }

    public String getTaxiStandName() {
        return taxiStandName;
    }

    public void setTaxiStandName(String taxiStandName) {
        this.taxiStandName = taxiStandName;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getPeopleQueueCount() {
        return peopleQueueCount;
    }

    public void setPeopleQueueCount(Integer peopleQueueCount) {
        this.peopleQueueCount = peopleQueueCount;
    }

    public String getExpectedWaitTime() {
        return expectedWaitTime;
    }

    public void setExpectedWaitTime(String expectedWaitTime) {
        this.expectedWaitTime = expectedWaitTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getLastrun() {
        return lastrun;
    }

    public void setLastrun(Date lastrun) {
        this.lastrun = lastrun;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxiStandId != null ? taxiStandId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Taxistand)) {
            return false;
        }
        Taxistand other = (Taxistand) object;
        if ((this.taxiStandId == null && other.taxiStandId != null) || (this.taxiStandId != null && !this.taxiStandId.equals(other.taxiStandId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ihpc.cmma.model.Taxistand[ taxiStandId=" + taxiStandId + " ]";
    }
    
}
