/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Sruthi
 */
@Entity
@Table(name = "camera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Camera.findAll", query = "SELECT c FROM Camera c"),
    @NamedQuery(name = "Camera.findByCameraId", query = "SELECT c FROM Camera c WHERE c.cameraId = :cameraId"),
    @NamedQuery(name = "Camera.findByCamLatLong", query = "SELECT c FROM Camera c WHERE c.camLatLong = :camLatLong"),
    @NamedQuery(name = "Camera.findByCrowd", query = "SELECT c FROM Camera c WHERE c.crowd = :crowd")})
public class Camera implements Serializable {
    @Size(max = 10)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lastrun")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastrun;
    @Column(name = "crowd")
    private Integer crowd;
    @Size(max = 15)
    @Column(name = "cameraCode")
    private String cameraCode;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cameraId")
    private Integer cameraId;
    @Size(max = 100)
    @Column(name = "camLatLong")
    private String camLatLong;
    @JoinColumn(name = "levelId", referencedColumnName = "mallLevelId")
    @ManyToOne
    private MallLevel levelId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "camId")
    private Collection<CamRegion> camRegionCollection;

    public Camera() {
    }

    public Camera(Integer cameraId) {
        this.cameraId = cameraId;
    }

    public Integer getCameraId() {
        return cameraId;
    }

    public void setCameraId(Integer cameraId) {
        this.cameraId = cameraId;
    }

    public String getCamLatLong() {
        return camLatLong;
    }

    public void setCamLatLong(String camLatLong) {
        this.camLatLong = camLatLong;
    }


    @XmlTransient
    @JsonIgnore
    public MallLevel getLevelId() {
        return levelId;
    }

    public void setLevelId(MallLevel levelId) {
        this.levelId = levelId;
    }

    public Collection<CamRegion> getCamRegionCollection() {
        return camRegionCollection;
    }

    public void setCamRegionCollection(Collection<CamRegion> camRegionCollection) {
        this.camRegionCollection = camRegionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cameraId != null ? cameraId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Camera)) {
            return false;
        }
        Camera other = (Camera) object;
        if ((this.cameraId == null && other.cameraId != null) || (this.cameraId != null && !this.cameraId.equals(other.cameraId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ihpc.cmma.model.Camera[ cameraId=" + cameraId + " ]";
    }

    public String getCameraCode() {
        return cameraCode;
    }

    public void setCameraCode(String cameraCode) {
        this.cameraCode = cameraCode;
    }

    public Integer getCrowd() {
        return crowd;
    }

    public void setCrowd(Integer crowd) {
        this.crowd = crowd;
    }

    public Date getLastrun() {
        return lastrun;
    }

    public void setLastrun(Date lastrun) {
        this.lastrun = lastrun;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
