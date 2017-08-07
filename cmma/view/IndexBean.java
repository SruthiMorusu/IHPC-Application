/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ihpc.cmma.view;

import com.ihpc.cmma.business.EventBusiness;
import com.ihpc.cmma.business.TaxiBusiness;
import com.ihpc.cmma.util.ApplicationContextProvider;
import javax.faces.bean.ManagedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 *
 * @author Sruthi
 */
@ManagedBean
public class IndexBean extends SpringBeanAutowiringSupport{
    private String message  = "CMMA Web Interface";
    @Autowired
    private TaxiBusiness business;

    public void setBusiness(TaxiBusiness business) {
        this.business = business;
    }
   
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String testCrowd() throws Exception{
        EventBusiness business = (EventBusiness) ApplicationContextProvider.getApplicationContext().getBean("EventBusinessImpl");
        business.loadEvents();
        return null;
    }
    
}
