/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ihpc.cmma.rest;

import com.ihpc.cmma.business.EventBusiness;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Event;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 *
 * @author Sruthi
 */
@Path("/event")
public class EventWsResource extends SpringBeanAutowiringSupport{
    
    @Autowired
    private EventBusiness eventBusiness;

    public void setEventBusiness(EventBusiness eventBusiness) {
        this.eventBusiness = eventBusiness;
    }
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> getAllEvents() throws CmmaAppException{
        return eventBusiness.getAllEvents();
    }
}
