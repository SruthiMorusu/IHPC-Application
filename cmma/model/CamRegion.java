/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author sruthi
 */
@Entity
@Table(name = "camregion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CamRegion.findAll", query = "SELECT c FROM CamRegion c"),
    @NamedQuery(name = "CamRegion.findByLatLong", query = "SELECT c FROM CamRegion c WHERE c.latLong = :latLong"),
    @NamedQuery(name = "CamRegion.findByVertex", query = "SELECT c FROM CamRegion c WHERE c.vertex = :vertex")})
public class CamRegion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 100)
    @Column(name = "latLong")
    private String latLong;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vertex")
    private Integer vertex;
    @JoinColumn(name = "camId", referencedColumnName = "cameraId")
    @ManyToOne(optional = false)
    private Camera camId;

    public CamRegion() {
    }

    public CamRegion(Integer vertex) {
        this.vertex = vertex;
    }

    public String getLatLong() {
        return latLong;
    }

    public void setLatLong(String latLong) {
        this.latLong = latLong;
    }

    public Integer getVertex() {
        return vertex;
    }

    public void setVertex(Integer vertex) {
        this.vertex = vertex;
    }

    @XmlTransient
    @JsonIgnore
    public Camera getCamId() {
        return camId;
    }

    public void setCamId(Camera camId) {
        this.camId = camId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vertex != null ? vertex.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CamRegion)) {
            return false;
        }
        CamRegion other = (CamRegion) object;
        if ((this.vertex == null && other.vertex != null) || (this.vertex != null && !this.vertex.equals(other.vertex))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ihpc.cmma.model.CamRegion[ vertex=" + vertex + " ]";
    }
    
}
