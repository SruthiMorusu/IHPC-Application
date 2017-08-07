/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.view;

import com.ihpc.cmma.business.EventBusiness;
import com.ihpc.cmma.business.NotificationBusiness;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Event;
import com.ihpc.cmma.util.CmmaConstants;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 *
 * @author Sruthi
 */
@Named
@ViewScoped
public class EventView extends SpringBeanAutowiringSupport {

    private Event event;
    private final Date currentDate = new Date();

    public Date getCurrentDate() {
        return currentDate;
    }

    @Autowired
    private EventBusiness eventBusiness;

    @Autowired
    private NotificationBusiness notificationBusiness;

    public void setNotificationBusiness(NotificationBusiness notificationBusiness) {
        this.notificationBusiness = notificationBusiness;
    }
    
    public Event getEvent() {
        return event;
    }

    public void setEventBusiness(EventBusiness eventBusiness) {
        this.eventBusiness = eventBusiness;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @PostConstruct
    public void init() {
        event = new Event();
    }

    public String createEventView()  {

        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            HttpServletRequest req = (HttpServletRequest) fc.getExternalContext().getRequest();
            HttpSession session = req.getSession();
            String username = session.getAttribute("username").toString();
            event.setShopkeeperName(username);
            
            String eventName = this.event.getEventName();
            String eventDesc = this.event.getEventDescription();
            String eventVenue = this.event.getEventVenue();
            Date eventStartDate = this.event.getEventStartDate();
            Date eventEndDate = this.event.getEventEndDate();
            event.setStatus(CmmaConstants.NUMBER_ONE);
            
            if (eventName.equals("") || eventDesc.equals("") || eventVenue.equals("") || eventStartDate == null || eventEndDate == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Please Enter All Fields"));
                return null;
            } else if (eventBusiness.validateEvent(event) == true) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Event already Exists"));
                return null;
            } else if (eventBusiness.isValidateDateRange(eventStartDate, eventEndDate) == false) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Please enter valid dates"));
                return null;
            } else if (eventBusiness.createEventBusniess(event).equalsIgnoreCase("success")) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.getExternalContext().getFlash().setKeepMessages(true);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Event Created"));
               
                final String x = "somethingelse";
                new Thread(new Runnable() {
                public void run() {
                x.matches("something"); 
                    try {
                        notificationBusiness.notifyEvent(event);
                    } catch (CmmaAppException ex) {
                        Logger.getLogger(EventView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                }).start();
            }
            
        } catch (CmmaAppException ex) {
            Logger.getLogger(EventView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void modifyEventView() throws SQLException {
        try {
            String eventName = this.event.getEventName();
            String eventDesc = this.event.getEventDescription();
            String eventVenue = this.event.getEventVenue();
            Date eventStartDate = this.event.getEventStartDate();
            Date eventEndDate = this.event.getEventEndDate();
            if (eventName.equals("") || eventDesc.equals("") || eventVenue.equals("") || eventStartDate == null || eventEndDate == null) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Please Enter Mandatory Fields"));
                
            } else if (eventBusiness.isValidateDateRange(eventStartDate, eventEndDate) == false) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Please enter valid dates"));
                
            } else if (eventBusiness.modifyEventBusiness(event) == true) {
                
                FacesContext context = FacesContext.getCurrentInstance();
                context.getExternalContext().getFlash().setKeepMessages(true);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Event Modified"));
                
            }
        } catch (CmmaAppException ex) {
            Logger.getLogger(EventView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onRowSelect(SelectEvent selectevent) throws IOException {
        System.out.println(((Event) selectevent.getObject()).getEventId());

        event = (Event) selectevent.getObject();
        RequestContext.getCurrentInstance().update(":dimo");
    }

    public void deleteEventView() throws SQLException {
        try {
            if(event.getEventName()==null)
            {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Enter Event Name"));
            }else{
            event.setStatus(CmmaConstants.NUMBER_ZERO);
            eventBusiness.deleteEventBusiness(event);
            //event.setEventName("");
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Event Deleted"));
            }
        } catch (CmmaAppException ex) {
            Logger.getLogger(EventView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
