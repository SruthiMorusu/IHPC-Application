/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.rest;

import com.ihpc.cmma.business.NotificationBusiness;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.MobileToken;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 *
 * @author Sruthi
 */
@Path("/register")
public class PushNotification extends SpringBeanAutowiringSupport{
    @Autowired
    private NotificationBusiness business;
    @GET
	@Path("token={value}")
	public void get(@PathParam("value") String value) {
		      MobileToken token = new MobileToken();
                      token.setToken(value);
        try {
            business.registerMobileBusiness(token);
        } catch (CmmaAppException ex) {
            Logger.getLogger(PushNotification.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
}
