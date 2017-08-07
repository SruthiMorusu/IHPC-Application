/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.rest;

import com.ihpc.cmma.business.BusStandBusiness;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.exception.CmmaMongoException;
import com.ihpc.cmma.model.BusStand;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 *
 * @author A0120035A
 */
@Path("/bus")
public class BusStandWsResource extends SpringBeanAutowiringSupport{
    
    @Autowired
    private BusStandBusiness business;

    public void setBusiness(BusStandBusiness business) {
        this.business = business;
    }
    
    @GET
    @Path("/stops")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BusStand> getAllBusStands(){
        List<BusStand> busStands =null;
        try {
            busStands = business.getAllBusBusiness();
        } catch (CmmaAppException ex) {
            Logger.getLogger(BusStandWsResource.class.getName()).log(Level.SEVERE, null, ex);
            busStands = new ArrayList<>();
        }
        return busStands;
    }
}
