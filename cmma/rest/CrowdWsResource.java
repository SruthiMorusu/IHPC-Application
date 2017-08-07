/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.rest;

import com.ihpc.cmma.business.SportsHubBusiness;
import com.ihpc.cmma.business.TaxiBusiness;
import com.ihpc.cmma.business.VenueBusiness;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.MallCrowd;
import com.ihpc.cmma.model.SportsHubGate;
import com.ihpc.cmma.model.Taxistand;
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
 * @author Sruthi
 */
@Path("/crowd")
public class CrowdWsResource extends SpringBeanAutowiringSupport {

    @Autowired
    private TaxiBusiness taxiBusiness;

    @Autowired
    private VenueBusiness venueBusiness;
    
    @Autowired
    private SportsHubBusiness hubBusiness;

   

    @GET
    @Path("/venue")
    @Produces(MediaType.APPLICATION_JSON)
    public MallCrowd getVenueCrowd() {

        try {
            MallCrowd cam = venueBusiness.getVenueCrowd("suntec");
            //cam.setLevels((List<MallLevel>) cam.getMallLevelCollection());
            return cam;
        } catch (CmmaAppException ex) {
            Logger.getLogger(CrowdWsResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @GET
    @Path("/taxi")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Taxistand> getTaxiCrowd() {

        try {

            List<Taxistand> taxistands = taxiBusiness.getTaxiStandBusiness();
            return taxistands;
        } catch (CmmaAppException ex) {
            Logger.getLogger(CrowdWsResource.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return new ArrayList<>();
    }
    
    @GET
    @Path("/sports")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SportsHubGate> getSportsCrowd() {

        try {

            List<SportsHubGate> gates = hubBusiness.getAllGatesBusiness();
            return gates;
        } catch (CmmaAppException ex) {
            Logger.getLogger(CrowdWsResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }
    
     public void setTaxiBusiness(TaxiBusiness taxiBusiness) {
        this.taxiBusiness = taxiBusiness;
    }

    public void setVenueBusiness(VenueBusiness venueBusiness) {
        this.venueBusiness = venueBusiness;
    }

    public void setHubBusiness(SportsHubBusiness hubBusiness) {
        this.hubBusiness = hubBusiness;
    }
    
    
}
