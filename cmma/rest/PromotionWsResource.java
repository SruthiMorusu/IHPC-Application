/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.rest;

import com.ihpc.cmma.business.PromotionBusiness;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Promotion;
import java.io.IOException;
import java.util.List;
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
@Path("/promotion")
public class PromotionWsResource extends SpringBeanAutowiringSupport {

    @Autowired
    private PromotionBusiness promotionBusiness;

    public void setPromotionBusiness(PromotionBusiness promotionBusiness) {
        this.promotionBusiness = promotionBusiness;
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Promotion> getAllPromotions()  throws CmmaAppException,IOException{
        return promotionBusiness.getAllPromosBusiness();
    }
}
