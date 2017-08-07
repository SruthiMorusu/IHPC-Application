/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.view;


import java.io.IOException;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import com.ihpc.cmma.exception.CmmaException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *  Shopkeepers Home page where the shopkeeper is given options to maintain Events and Promotions
 * @author Team3FT
 */
@ManagedBean
@RequestScoped
public class HomePageView {
    
    
    
     /**
     * This method gives the link to Create Event Page which will redirect the shopkeeper to Create a new Event
     * this method redirects to error page if the IO exception occurs
     *  * This method always returns null in order to stay on the same vIew
*/
    public String displayCreateEvent()
    {
       ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
       try {
                context.redirect(context.getRequestContextPath() + "createEvent.xhtml");
            } catch (IOException e1) {
                
                e1.getMessage();
                Logger.getLogger(HomePageView.class.getName()).log(Level.SEVERE, null, e1);
            
            return "error.xhtml";
            }
       return null;
    }
    
    /**
     * This method gives the link to Modify Event Page which will redirect the shopkeeper to Modify the Existing Events 
     * this method redirects to error page if the IO exception occurs
     *  * This method always returns null in order to stay on the same vIew
*/
    public String displayModifyEvent()
    {
       ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
       try {
                context.redirect(context.getRequestContextPath() + "modifyEvent.xhtml");
            } catch (IOException e1) {
                
                e1.getMessage();
                Logger.getLogger(HomePageView.class.getName()).log(Level.SEVERE, null, e1);
            
            return "error.xhtml";
            }
       return null;
    }
     /**
     * This method gives the link to Delete Event Page which will redirect the shopkeeper to Delete the Existing Events 
     * this method redirects to error page if the IO exception occurs
     * This method always returns null in order to stay on the same vIew
*/
     public String displayDeleteEvent()
    {
       ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
       try {
                context.redirect(context.getRequestContextPath() + "deleteEvent.xhtml");
            } catch (IOException e1) {
                
                e1.getMessage();
                 Logger.getLogger(HomePageView.class.getName()).log(Level.SEVERE, null, e1);
            
            return "error.xhtml";
            }
       return null;
    }
        /**
     * This method gives the link to Create Promotion Page which will redirect the shopkeeper to Create a new Event
     * this method redirects to error page if the IO exception occurs
     *  * This method always returns null in order to stay on the same vIew
*/
    public String displayCreatePromotion()
    {
       ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
       try {
                context.redirect(context.getRequestContextPath() + "createEvent.xhtml");
            } catch (IOException e1) {
                
                e1.getMessage();
                Logger.getLogger(HomePageView.class.getName()).log(Level.SEVERE, null, e1);
            
            return "error.xhtml";
            }
       return null;
    }
     
       /**
     * This method gives the link to Modify Promotion Page which will redirect the shopkeeper to Modify the Existing Promotion 
     * this method redirects to error page if the IO exception occurs
     * This method always returns null in order to stay on the same view
*/
      public String displayModifyPromotion()
    {
       ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
       try {
                context.redirect(context.getRequestContextPath() + "modifyPromotion.xhtml");
            } catch (IOException e1) {
                
                e1.getMessage();
                 Logger.getLogger(HomePageView.class.getName()).log(Level.SEVERE, null, e1);
            
            return "error.xhtml";
            }
       return null;
    }
            /**
     * This method gives the link to Delete Promotion Page which will redirect the shopkeeper to Delete the Existing Promotion 
     * this method redirects to error page if the IO exception occurs
     * This method always returns null in order to stay on the same view
*/
       public String displayDeletePromotion()
    {
       ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
       try {
                context.redirect(context.getRequestContextPath() + "deletePromotion.xhtml");
            } catch (IOException e1) {
                
                e1.getMessage();
                 Logger.getLogger(HomePageView.class.getName()).log(Level.SEVERE, null, e1);
            
            return "error.xhtml";
            }
       return null;
    }
       
      
    
    
    
}
