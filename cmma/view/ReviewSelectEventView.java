/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.view;

import com.ihpc.cmma.business.EventBusiness;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Event;
import com.ihpc.cmma.model.Promotion;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 *
 * @author Sruthi
 */
@ManagedBean
public class ReviewSelectEventView extends SpringBeanAutowiringSupport{
    private Event event,selectedEvent;
    private List<Event> eventList;
    @Autowired
    private EventBusiness eventBusiness;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Event getSelectedEvent() {
        return selectedEvent;
    }

    public void setSelectedEvent(Event selectedEvent) {
        this.selectedEvent = selectedEvent;
    }

    public List<Event> getEventList() {
        return eventList;
    }
    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public EventBusiness getEventBusiness() {
        return eventBusiness;
    }

    public void setEventBusiness(EventBusiness eventBusiness) {
        this.eventBusiness = eventBusiness;
    }
     @PostConstruct
    public void init()  {
    event = new Event();
       FacesContext fc = FacesContext.getCurrentInstance();
                HttpServletRequest req = (HttpServletRequest) fc.getExternalContext().getRequest();
                HttpSession session = req.getSession();
          String shopkeeperName=(String) session.getAttribute("username");
         try{
    eventList=eventBusiness.allEvents(shopkeeperName);
         }
         catch(CmmaAppException e )
         {
         
          e.getMessage();
    Logger.getLogger(ReviewSelectEventView.class.getName()).log(Level.SEVERE, null, e);
   
ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
try{
context.redirect("error.xhtml");
}
catch (IOException e1)
{
        e.getMessage();
    Logger.getLogger(ReviewSelectEventView.class.getName()).log(Level.SEVERE, null, e1);
}
         }
          
          
         
    }
    public Event onRowSelect(SelectEvent selectevent)  {
        System.out.println(((Event) selectevent.getObject()).getEventId());
      
       event=(Event) selectevent.getObject();
          System.out.println(event.getEventName());
        selectedEvent.setEventName(((Event) selectevent.getObject()).getEventName());
       ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
       try{
context.redirect(context.getRequestContextPath() + "EventModify.xhtml");
       }
       catch (IOException e1)
{
        e1.getMessage();
    Logger.getLogger(ReviewSelectEventView.class.getName()).log(Level.SEVERE, null, e1);
}
        return selectedEvent;
        
        
    }
}
