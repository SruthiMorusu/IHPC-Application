/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.rest;

import com.ihpc.cmma.business.ShopBusiness;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.exception.CmmaMongoException;
import com.ihpc.cmma.model.Category;
import com.ihpc.cmma.model.Shop;
import java.util.List;
import java.util.Map;
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
@Path("/category")
public class CategoryWsResource extends SpringBeanAutowiringSupport {

    @Autowired
    private ShopBusiness shopBusiness;

    public void setShopBusiness(ShopBusiness shopBusiness) {
        this.shopBusiness = shopBusiness;
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getAllCategories() throws CmmaAppException {
        return shopBusiness.getCategotyBusiness();
    }
}
