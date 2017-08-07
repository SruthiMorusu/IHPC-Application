/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.view;

import com.ihpc.cmma.business.PromotionBusiness;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Promotion;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 *
 * @author Sruthi
 */
@ManagedBean
public class ReviewSelectPromotionView extends SpringBeanAutowiringSupport{
    
    private Promotion  promotion;
    private Promotion selectedPromotion;
    private Date currentDate= new Date();
    public Date getCurrentDate(){
        return currentDate;
    }


    public Promotion getSelectedPromotion() {
        return selectedPromotion;
    }

    public void setSelectedPromotion(Promotion selectedPromotion) {
        this.selectedPromotion = selectedPromotion;
    }
 private List<Promotion> promotionList;
 @Autowired
    private PromotionBusiness promotionBusiness;

    public PromotionBusiness getPromotionBusiness() {
        return promotionBusiness;
    }

    public void setPromotionBusiness(PromotionBusiness promotionBusiness) {
        this.promotionBusiness = promotionBusiness;
    }
    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public List<Promotion> getPromotionList() {
        
        return promotionList;
    }

    public void setPromotionList(List<Promotion> promotionList) {
        this.promotionList = promotionList;
    }
   
    
     @PostConstruct
    public void init() {
    promotion = new Promotion();
    
    
        
           FacesContext fc = FacesContext.getCurrentInstance();
                HttpServletRequest req = (HttpServletRequest) fc.getExternalContext().getRequest();
                HttpSession session = req.getSession();
          String shopkeeperName=(String) session.getAttribute("username");
         try{
         promotionList=promotionBusiness.allPromotions(shopkeeperName);
         }
         catch(CmmaAppException | IOException e)
         {
                    e.getMessage();
    Logger.getLogger(ReviewSelectPromotionView.class.getName()).log(Level.SEVERE, null, e);
         
         }
         
    }
    
     public List<Promotion> modifyPromotionView() 
    {
           try{  
        return promotionBusiness.getAllPromosBusiness();
           }
           catch(CmmaAppException | IOException e) 
           {
            e.getMessage();
    Logger.getLogger(ReviewSelectPromotionView.class.getName()).log(Level.SEVERE, null, e);
     
           return null;
           }
           
    }
    public void onRowSelect(SelectEvent event)  {
        System.out.println(((Promotion) event.getObject()).getPromotionId());
       promotion=(Promotion) event.getObject();
      
        //selectedPromotion.setPromotionName(((Promotion) event.getObject()).getPromotionName());
       
    }
                  
        
         
   } 
     
        

