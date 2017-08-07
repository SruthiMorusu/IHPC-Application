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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sruthi
 */
@Entity
@Table(name = "shopkeeper")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shopkeeper.findAll", query = "SELECT s FROM Shopkeeper s"),
    @NamedQuery(name = "Shopkeeper.findByShopkeeperId", query = "SELECT s FROM Shopkeeper s WHERE s.shopkeeperId = :shopkeeperId"),
    @NamedQuery(name = "Shopkeeper.findByCompanyName", query = "SELECT s FROM Shopkeeper s WHERE s.companyName = :companyName"),
    @NamedQuery(name = "Shopkeeper.findByShopNumber", query = "SELECT s FROM Shopkeeper s WHERE s.shopNumber = :shopNumber"),
    @NamedQuery(name = "Shopkeeper.findByShopkeeperName", query = "SELECT s FROM Shopkeeper s WHERE s.shopkeeperName = :shopkeeperName"),
    @NamedQuery(name = "Shopkeeper.findByShopkeeperPassword", query = "SELECT s FROM Shopkeeper s WHERE s.shopkeeperPassword = :shopkeeperPassword"),
    @NamedQuery(name = "Shopkeeper.findByEmailid", query = "SELECT s FROM Shopkeeper s WHERE s.emailid = :emailid")})
public class Shopkeeper implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "shopkeeperId")
    private Integer shopkeeperId;
    @Size(max = 45)
    @Column(name = "companyName")
    private String companyName;
    @Size(max = 45)
    @Column(name = "shopNumber")
    private String shopNumber;
    @Size(max = 20)
    @Column(name = "shopkeeperName")
    private String shopkeeperName;
    @Size(max = 20)
    @Column(name = "shopkeeperPassword")
    private String shopkeeperPassword;
    @Size(max = 20)
    @Column(name = "emailid")
    private String emailid;
    @Transient
    private String confimPassword;

    public String getConfimPassword() {
        return confimPassword;
    }

    public void setConfimPassword(String confimPassword) {
        this.confimPassword = confimPassword;
    }
    
    public Shopkeeper() {
    }

    public Shopkeeper(Integer shopkeeperId) {
        this.shopkeeperId = shopkeeperId;
    }

    public Integer getShopkeeperId() {
        return shopkeeperId;
    }

    public void setShopkeeperId(Integer shopkeeperId) {
        this.shopkeeperId = shopkeeperId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getShopNumber() {
        return shopNumber;
    }

    public void setShopNumber(String shopNumber) {
        this.shopNumber = shopNumber;
    }

    public String getShopkeeperName() {
        return shopkeeperName;
    }

    public void setShopkeeperName(String shopkeeperName) {
        this.shopkeeperName = shopkeeperName;
    }

    public String getShopkeeperPassword() {
        return shopkeeperPassword;
    }

    public void setShopkeeperPassword(String shopkeeperPassword) {
        this.shopkeeperPassword = shopkeeperPassword;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shopkeeperId != null ? shopkeeperId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shopkeeper)) {
            return false;
        }
        Shopkeeper other = (Shopkeeper) object;
        if ((this.shopkeeperId == null && other.shopkeeperId != null) || (this.shopkeeperId != null && !this.shopkeeperId.equals(other.shopkeeperId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ihpc.cmma.model.Shopkeeper[ shopkeeperId=" + shopkeeperId + " ]";
    }
    
}
