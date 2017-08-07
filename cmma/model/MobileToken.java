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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dimo
 */
@Entity
@Table(name = "mobiletoken")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MobileToken.findAll", query = "SELECT m FROM MobileToken m"),
    @NamedQuery(name = "MobileToken.findByTokenId", query = "SELECT m FROM MobileToken m WHERE m.tokenId = :tokenId"),
    @NamedQuery(name = "MobileToken.findByToken", query = "SELECT m FROM MobileToken m WHERE m.token = :token")})
public class MobileToken implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tokenId")
    private Integer tokenId;
    @Size(max = 100)
    @Column(name = "token")
    private String token;

    public MobileToken() {
    }

    public MobileToken(Integer tokenId) {
        this.tokenId = tokenId;
    }

    public Integer getTokenId() {
        return tokenId;
    }

    public void setTokenId(Integer tokenId) {
        this.tokenId = tokenId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tokenId != null ? tokenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MobileToken)) {
            return false;
        }
        MobileToken other = (MobileToken) object;
        if ((this.tokenId == null && other.tokenId != null) || (this.tokenId != null && !this.tokenId.equals(other.tokenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ihpc.cmma.model.MobileToken[ tokenId=" + tokenId + " ]";
    }
    
}
