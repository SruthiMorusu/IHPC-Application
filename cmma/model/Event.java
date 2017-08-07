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
 * @author Sruthi
 */
@Entity
@Table(name = "event")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e"),
    @NamedQuery(name = "Event.findByEventId", query = "SELECT e FROM Event e WHERE e.eventId = :eventId"),
    @NamedQuery(name = "Event.findByEventName", query = "SELECT e FROM Event e WHERE e.eventName = :eventName"),
    @NamedQuery(name = "Event.findByEventDescription", query = "SELECT e FROM Event e WHERE e.eventDescription = :eventDescription"),
    @NamedQuery(name = "Event.findByEventStartDate", query = "SELECT e FROM Event e WHERE e.eventStartDate = :eventStartDate"),
    @NamedQuery(name = "Event.findByEventEndDate", query = "SELECT e FROM Event e WHERE e.eventEndDate = :eventEndDate"),
    @NamedQuery(name = "Event.findByEventVenue", query = "SELECT e FROM Event e WHERE e.eventVenue = :eventVenue"),
    @NamedQuery(name = "Event.findByEventPhoto", query = "SELECT e FROM Event e WHERE e.eventPhoto = :eventPhoto"),
    @NamedQuery(name = "Event.findByIsWebCrawled", query = "SELECT e FROM Event e WHERE e.isWebCrawled = :isWebCrawled"),
    @NamedQuery(name = "Event.findByShopkeeperName", query = "SELECT e FROM Event e WHERE e.shopkeeperName = :shopkeeperName"),
    @NamedQuery(name = "Event.findByStatus", query = "SELECT e FROM Event e WHERE e.status = :status")})
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EventId")
    private Integer eventId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "EventName")
    private String eventName;
    @Size(max = 255)
    @Column(name = "EventDescription")
    private String eventDescription;
    @Column(name = "EventStartDate")
    @Temporal(TemporalType.DATE)
    private Date eventStartDate;
    @Column(name = "EventEndDate")
    @Temporal(TemporalType.DATE)
    private Date eventEndDate;
    @Size(max = 45)
    @Column(name = "EventVenue")
    private String eventVenue;
    @Size(max = 200)
    @Column(name = "EventPhoto")
    private String eventPhoto;
    @Column(name = "isWebCrawled")
    private Integer isWebCrawled;
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
    private String eventPhotoByte;

    public Event() {
    }

    public Event(Integer eventId) {
        this.eventId = eventId;
    }

    public Event(Integer eventId, String eventName) {
        this.eventId = eventId;
        this.eventName = eventName;
    }

    public String getEventPhotoByte() {
        return eventPhotoByte;
    }

    public void setEventPhotoByte(String eventPhotoByte) {
        this.eventPhotoByte = eventPhotoByte;
    }
    
    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Date getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(Date eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public Date getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(Date eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public String getEventPhoto() {
        return eventPhoto;
    }

    public void setEventPhoto(String eventPhoto) {
        this.eventPhoto = eventPhoto;
    }

    public Integer getIsWebCrawled() {
        return isWebCrawled;
    }

    public void setIsWebCrawled(Integer isWebCrawled) {
        this.isWebCrawled = isWebCrawled;
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
        hash += (eventId != null ? eventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.eventId == null && other.eventId != null) || (this.eventId != null && !this.eventId.equals(other.eventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ihpc.cmma.model.Event[ eventId=" + eventId + " ]";
    }
    
}
