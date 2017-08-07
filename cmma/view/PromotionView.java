/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.view;

import com.ihpc.cmma.business.PromotionBusiness;
import com.ihpc.cmma.exception.CmmaException;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Promotion;
import com.ihpc.cmma.util.CmmaConstants;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@ManagedBean
@ViewScoped
public class PromotionView extends SpringBeanAutowiringSupport {

    private Promotion promotion;
    private final Date currentDate = new Date();

    public Date getCurrentDate() {
        return currentDate;
    }
    
    @Autowired
    private PromotionBusiness promotionBusiness;
    private String ShopkeeperName;
    
    public Promotion getPromotion() {
        return promotion;
    }
    
    public PromotionBusiness getPromotionBusiness() {
        return promotionBusiness;
    }
    
    public void setPromotionBusiness(PromotionBusiness promotionBusiness) {
        this.promotionBusiness = promotionBusiness;
    }
    
    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    @PostConstruct
    public void init() {
        promotion = new Promotion();
        
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest req = (HttpServletRequest) fc.getExternalContext().getRequest();
        HttpSession session = req.getSession();
        ShopkeeperName = (String) session.getAttribute("username");
    }
    
    public String createPromotionView() {
        
        String promotionName = this.promotion.getPromotionName();
        String promotionDesc = this.promotion.getPromotionDescription();
        Date promotionStartDate = this.promotion.getPromotionStartDate();
        Date promotionEndDate = this.promotion.getPromotionEndDate();
        
        promotion.setShopkeeperName(ShopkeeperName);
        promotion.setStatus(1);
        
        try {
            
            if (promotionName.equals("") || promotionDesc.equals("") || promotionStartDate == null || promotionEndDate == null) {
                
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Please Enter Mandatory Fields"));
                return null;
            } else if (promotionBusiness.promotionValidate(promotion) == true) {                
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Promotion already Exists"));
                return null;
            } else if (promotionBusiness.isValidateDateRange(promotionStartDate, promotionEndDate) == false) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Please enter valid dates"));
                return null;
            } else if (promotionBusiness.createPromotionBusiness(promotion).equals("success")) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.getExternalContext().getFlash().setKeepMessages(true);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Promotion successfully created"));
                
            }
        } catch (CmmaAppException e) {
            
            e.getMessage();
            Logger.getLogger(PromotionView.class.getName()).log(Level.SEVERE, null, e);
            
            return "error.xhtml";
        } catch (CmmaException | IOException ex) {
            
            ex.getMessage();
            Logger.getLogger(PromotionView.class.getName()).log(Level.SEVERE, null, ex);
            
            return "error.xhtml";
        }
        return null;
    }
    
    public void modifyPromotionView() {
        String promotionName = this.promotion.getPromotionName();
        String promotionDesc = this.promotion.getPromotionDescription();
        Date promotionStartDate = this.promotion.getPromotionStartDate();
        Date promotionEndDate = this.promotion.getPromotionEndDate();
        
        try {
            if (promotionName.equals("") || promotionDesc.equals("") || promotionStartDate == null || promotionEndDate == null) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Please Enter Mandatory Fields"));
                
            } else if (promotionBusiness.isValidateDateRange(promotionStartDate, promotionEndDate) == false) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Please enter valid dates"));
                
            } else if (promotionBusiness.modifyPromotionBusiness(promotion) == true) {
                
                FacesContext context = FacesContext.getCurrentInstance();
                context.getExternalContext().getFlash().setKeepMessages(true);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Promotion successfully updated"));
            }
            
        } catch (CmmaAppException e) {
            
            e.getMessage();
            Logger.getLogger(PromotionView.class.getName()).log(Level.SEVERE, null, e);
            
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            try {
                context.redirect(context.getRequestContextPath() + "error.xhtml");
            } catch (IOException e1) {
                
                e1.getMessage();
            }
        } catch (CmmaException e) {
            
            e.getMessage();
            Logger.getLogger(PromotionView.class.getName()).log(Level.SEVERE, null, e);
            
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            try {
                context.redirect(context.getRequestContextPath() + "error.xhtml");
            } catch (IOException e1) {
                e1.getMessage();
                
            }
            
        }
        
    }    
    
    public void deletePromotionView() {
        try {   
            if(promotion.getPromotionName()==null)
            {
                FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Enter Promotion Name"));
            }else {
            promotion.setStatus(CmmaConstants.NUMBER_ZERO);
            promotionBusiness.deletePromotionBusiness(promotion);
            
            //promotion.setPromotionName("");
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Promotion successfully deleted"));
            }
        } catch (CmmaAppException e) {
            
            e.getMessage();
            Logger.getLogger(EventView.class.getName()).log(Level.SEVERE, null, e);
            
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            try {
                context.redirect(context.getRequestContextPath() + "error.xhtml");
            } catch (IOException e1) {
                e1.getMessage();
                Logger.getLogger(PromotionView.class.getName()).log(Level.SEVERE, null, e1);
            }
            
        }
        
    }

    public void onRowSelect(SelectEvent event) {
        
        System.out.println(((Promotion) event.getObject()).getPromotionId());
        promotion = (Promotion) event.getObject();
        
    }
}
