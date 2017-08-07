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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author sruthi
 */
@Entity
@Table(name = "promotion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promotion.findAll", query = "SELECT p FROM Promotion p"),
    @NamedQuery(name = "Promotion.findByPromotionId", query = "SELECT p FROM Promotion p WHERE p.promotionId = :promotionId"),
    @NamedQuery(name = "Promotion.findByPromotionName", query = "SELECT p FROM Promotion p WHERE p.promotionName = :promotionName"),
    @NamedQuery(name = "Promotion.findByPromotionDescription", query = "SELECT p FROM Promotion p WHERE p.promotionDescription = :promotionDescription"),
    @NamedQuery(name = "Promotion.findByPromotionStartDate", query = "SELECT p FROM Promotion p WHERE p.promotionStartDate = :promotionStartDate"),
    @NamedQuery(name = "Promotion.findByPromotionEndDate", query = "SELECT p FROM Promotion p WHERE p.promotionEndDate = :promotionEndDate"),
    @NamedQuery(name = "Promotion.findByPromotionPhoto", query = "SELECT p FROM Promotion p WHERE p.promotionPhoto = :promotionPhoto"),
    @NamedQuery(name = "Promotion.findByShopkeeperName", query = "SELECT p FROM Promotion p WHERE p.shopkeeperName = :shopkeeperName"),
    @NamedQuery(name = "Promotion.findByStatus", query = "SELECT p FROM Promotion p WHERE p.status = :status")})
public class Promotion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PromotionId")
    private Integer promotionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PromotionName")
    private String promotionName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "PromotionDescription")
    private String promotionDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PromotionStartDate")
    @Temporal(TemporalType.DATE)
    private Date promotionStartDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PromotionEndDate")
    @Temporal(TemporalType.DATE)
    private Date promotionEndDate;
    @Size(max = 200)
    @Column(name = "PromotionPhoto")
    private String promotionPhoto;
    @Size(max = 20)
    @Column(name = "shopkeeperName")
    private String shopkeeperName;
    @Column(name = "Status")
    private Integer status;
    @Transient
    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
     @Transient
    private String promotionPhotoByte;
    public Promotion() {
    }
@Transient
    private String imagePath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public Promotion(Integer promotionId) {
        this.promotionId = promotionId;
    }

    public Promotion(Integer promotionId, String promotionName, String promotionDescription, Date promotionStartDate, Date promotionEndDate) {
        this.promotionId = promotionId;
        this.promotionName = promotionName;
        this.promotionDescription = promotionDescription;
        this.promotionStartDate = promotionStartDate;
        this.promotionEndDate = promotionEndDate;
    }

    public Integer getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Integer promotionId) {
        this.promotionId = promotionId;
    }

    public String getPromotionPhotoByte() {
        return promotionPhotoByte;
    }

    public void setPromotionPhotoByte(String promotionPhotoByte) {
        this.promotionPhotoByte = promotionPhotoByte;
    }
    
    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public String getPromotionDescription() {
        return promotionDescription;
    }

    public void setPromotionDescription(String promotionDescription) {
        this.promotionDescription = promotionDescription;
    }

    public Date getPromotionStartDate() {
        return promotionStartDate;
    }

    public void setPromotionStartDate(Date promotionStartDate) {
        this.promotionStartDate = promotionStartDate;
    }

    public Date getPromotionEndDate() {
        return promotionEndDate;
    }

    public void setPromotionEndDate(Date promotionEndDate) {
        this.promotionEndDate = promotionEndDate;
    }

    public String getPromotionPhoto() {
        return promotionPhoto;
    }

    public void setPromotionPhoto(String promotionPhoto) {
        this.promotionPhoto = promotionPhoto;
    }

    public String getShopkeeperName() {
        return shopkeeperName;
    }

    public void setShopkeeperName(String shopkeeperName) {
        this.shopkeeperName = shopkeeperName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (promotionId != null ? promotionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promotion)) {
            return false;
        }
        Promotion other = (Promotion) object;
        if ((this.promotionId == null && other.promotionId != null) || (this.promotionId != null && !this.promotionId.equals(other.promotionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ihpc.cmma.model.Promotion[ promotionId=" + promotionId + " ]";
    }
    
}
