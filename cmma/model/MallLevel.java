/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.model;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "malllevel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MallLevel.findAll", query = "SELECT m FROM MallLevel m"),
    @NamedQuery(name = "MallLevel.findByMallLevelId", query = "SELECT m FROM MallLevel m WHERE m.mallLevelId = :mallLevelId"),
    @NamedQuery(name = "MallLevel.findByMallLevelDesc", query = "SELECT m FROM MallLevel m WHERE m.mallLevelDesc = :mallLevelDesc"),
    @NamedQuery(name = "MallLevel.findByLevelNumber", query = "SELECT m FROM MallLevel m WHERE m.levelNumber = :levelNumber")})
public class MallLevel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mallLevelId")
    private Integer mallLevelId;
    @Size(max = 45)
    @Column(name = "mallLevelDesc")
    private String mallLevelDesc;
    @Size(max = 45)
    @Column(name = "levelNumber")
    private String levelNumber;
    @OneToMany(mappedBy = "levelId")
    private Collection<Camera> cameraCollection;
    @JoinColumn(name = "mallId", referencedColumnName = "mallId")
    @ManyToOne(optional = false)
    private MallCrowd mallId;

    public MallLevel() {
    }

    public MallLevel(Integer mallLevelId) {
        this.mallLevelId = mallLevelId;
    }

    public Integer getMallLevelId() {
        return mallLevelId;
    }

    public void setMallLevelId(Integer mallLevelId) {
        this.mallLevelId = mallLevelId;
    }

    public String getMallLevelDesc() {
        return mallLevelDesc;
    }

    public void setMallLevelDesc(String mallLevelDesc) {
        this.mallLevelDesc = mallLevelDesc;
    }

    public String getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(String levelNumber) {
        this.levelNumber = levelNumber;
    }

    
    public Collection<Camera> getCameraCollection() {
        return cameraCollection;
    }

    public void setCameraCollection(Collection<Camera> cameraCollection) {
        this.cameraCollection = cameraCollection;
    }

    @XmlTransient
    @JsonIgnore
    public MallCrowd getMallId() {
        return mallId;
    }

    public void setMallId(MallCrowd mallId) {
        this.mallId = mallId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mallLevelId != null ? mallLevelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MallLevel)) {
            return false;
        }
        MallLevel other = (MallLevel) object;
        if ((this.mallLevelId == null && other.mallLevelId != null) || (this.mallLevelId != null && !this.mallLevelId.equals(other.mallLevelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ihpc.cmma.model.MallLevel[ mallLevelId=" + mallLevelId + " ]";
    }
    
}
