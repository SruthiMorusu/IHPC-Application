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
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Sruthi
 */
@Entity
@Table(name = "sportshubgate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SportsHubGate.findAll", query = "SELECT s FROM SportsHubGate s"),
    @NamedQuery(name = "SportsHubGate.findByGateNumber", query = "SELECT s FROM SportsHubGate s WHERE s.gateNumber = :gateNumber"),
    @NamedQuery(name = "SportsHubGate.findByGateName", query = "SELECT s FROM SportsHubGate s WHERE s.gateName = :gateName"),
    @NamedQuery(name = "SportsHubGate.findByLatitude", query = "SELECT s FROM SportsHubGate s WHERE s.latitude = :latitude"),
    @NamedQuery(name = "SportsHubGate.findByLongitude", query = "SELECT s FROM SportsHubGate s WHERE s.longitude = :longitude"),
    @NamedQuery(name = "SportsHubGate.findByStatus", query = "SELECT s FROM SportsHubGate s WHERE s.status = :status"),
    @NamedQuery(name = "SportsHubGate.findByLastrun", query = "SELECT s FROM SportsHubGate s WHERE s.lastrun = :lastrun"),
    @NamedQuery(name = "SportsHubGate.findByCount", query = "SELECT s FROM SportsHubGate s WHERE s.crowdCount = :crowdCount")})
public class SportsHubGate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gateNumber")
    private Integer gateNumber;
    @Size(max = 45)
    @Column(name = "gateName")
    private String gateName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "status")
    private Integer status;
    @Column(name = "lastrun")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastrun;
    @Column(name = "crowdcount")
    private Integer crowdCount;
    @Transient
    private String color;

    public SportsHubGate() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public SportsHubGate(Integer gateNumber) {
        this.gateNumber = gateNumber;
    }

    public Integer getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(Integer gateNumber) {
        this.gateNumber = gateNumber;
    }

    public String getGateName() {
        return gateName;
    }

    public void setGateName(String gateName) {
        this.gateName = gateName;
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

    @JsonIgnore
    @XmlTransient
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonIgnore
    @XmlTransient
    public Date getLastrun() {
        return lastrun;
    }

    public void setLastrun(Date lastrun) {
        this.lastrun = lastrun;
    }

    public Integer getCrowdCount() {
        return crowdCount;
    }

    public void setCrowdCount(Integer crowdCount) {
        this.crowdCount = crowdCount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gateNumber != null ? gateNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SportsHubGate)) {
            return false;
        }
        SportsHubGate other = (SportsHubGate) object;
        if ((this.gateNumber == null && other.gateNumber != null) || (this.gateNumber != null && !this.gateNumber.equals(other.gateNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ihpc.cmma.model.SportsHubGate[ gateNumber=" + gateNumber + " ]";
    }

}
