/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Sruthi
 */
@Entity
@Table(name = "mallcrowd")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MallCrowd.findAll", query = "SELECT m FROM MallCrowd m"),
    @NamedQuery(name = "MallCrowd.findByMallId", query = "SELECT m FROM MallCrowd m WHERE m.mallId = :mallId"),
    @NamedQuery(name = "MallCrowd.findByMallName", query = "SELECT m FROM MallCrowd m WHERE m.mallName = :mallName"),
    @NamedQuery(name = "MallCrowd.findByMallLocation", query = "SELECT m FROM MallCrowd m WHERE m.mallLocation = :mallLocation")})
public class MallCrowd implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mallId")
    private Integer mallId;
    @Size(max = 45)
    @Column(name = "mallName")
    private String mallName;
    @Size(max = 45)
    @Column(name = "mallLocation")
    private String mallLocation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mallId")
    private Collection<MallLevel> mallLevelCollection;

    public MallCrowd() {
    }

    public MallCrowd(Integer mallId) {
        this.mallId = mallId;
    }

    public Integer getMallId() {
        return mallId;
    }

    public void setMallId(Integer mallId) {
        this.mallId = mallId;
    }

    public String getMallName() {
        return mallName;
    }

    public void setMallName(String mallName) {
        this.mallName = mallName;
    }

    public String getMallLocation() {
        return mallLocation;
    }

    public void setMallLocation(String mallLocation) {
        this.mallLocation = mallLocation;
    }

    
    public Collection<MallLevel> getMallLevelCollection() {
        return mallLevelCollection;
    }

    public void setMallLevelCollection(Collection<MallLevel> mallLevelCollection) {
        this.mallLevelCollection = mallLevelCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mallId != null ? mallId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MallCrowd)) {
            return false;
        }
        MallCrowd other = (MallCrowd) object;
        if ((this.mallId == null && other.mallId != null) || (this.mallId != null && !this.mallId.equals(other.mallId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ihpc.cmma.model.MallCrowd[ mallId=" + mallId + " ]";
    }
    
}
