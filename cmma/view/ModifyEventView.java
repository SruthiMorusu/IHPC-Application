/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.view;

import com.ihpc.cmma.business.EventBusiness;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Event;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 *
 * @author Sruthi
 */
@ManagedBean
@RequestScoped
public class ModifyEventView extends SpringBeanAutowiringSupport {

    private Event event;
    @Autowired
    private EventBusiness eventBusiness;
    private List<Event> listOfEvent;
    private Integer selectedEventId;
    private Event selectedEvent;

    public Integer getSelectedEventId() {
        return selectedEventId;
    }

    public void setSelectedEventId(Integer selectedEventId) {
        this.selectedEventId = selectedEventId;
    }

    public Event getSelectedEvent() {
        return selectedEvent;
    }

    public void setSelectedEvent(Event selectedEvent) {
        this.selectedEvent = selectedEvent;
    }

    public List<Event> getListOfEvent() {
        try {
            return eventBusiness.getAllEvents();
        } catch (CmmaAppException e) {
            e.getMessage();
            Logger.getLogger(ModifyEventView.class.getName()).log(Level.SEVERE, null, e);
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            try {
                context.redirect(context.getRequestContextPath() + "error.xhtml");
            } catch (IOException e1) {
                e1.getMessage();
            }
            return null;

        }
    }

    public void setListOfEvent(List<Event> listOfEvent) {
        this.listOfEvent = listOfEvent;
    }

    public Event getEvent() {
        return event;
    }

    public EventBusiness getEventBusiness() {
        return eventBusiness;
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

    public void modifyEventView() {
        try {
            eventBusiness.modifyEventBusiness(event);
        } catch (CmmaAppException e) {

            e.getMessage();
            Logger.getLogger(ModifyEventView.class.getName()).log(Level.SEVERE, null, e);
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            try {
                context.redirect(context.getRequestContextPath() + "error.xhtml");
            } catch (IOException e1) {

                e1.getMessage();

            }
        }
    }

                // listOfSubjectTags = (List<SubjectTag>) m.getSubjectTagCollection();
    public void select() {
        for (Event ev : listOfEvent) {
            if (ev.getEventId() == selectedEventId) {
                selectedEvent = ev;
            }
        }
    }

}
