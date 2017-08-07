/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.view;

import com.ihpc.cmma.model.Promotion;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.event.SelectEvent;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 *
 * @author Sruthi
 */
@ManagedBean

public class ModifyPromotionsView extends SpringBeanAutowiringSupport{
    
    private ReviewSelectPromotionView RSPromotionView;
    public Promotion promotion;
    
ReviewSelectPromotionView rsPromotion = (ReviewSelectPromotionView) FacesContext.getCurrentInstance().
		getExternalContext().getRequestMap().get("rspromotionView");
    public ReviewSelectPromotionView getRSPromotionView() {
       
        return RSPromotionView;
    }

    public void setRSPromotionView(ReviewSelectPromotionView RSPromotionView) {
        this.RSPromotionView = RSPromotionView;
    }
  @PostConstruct
    public void init() {
//        
//      System.out.println(RSPromotionView.getPromotion());
      
 
    }
     public Promotion onRowSelect(SelectEvent event) {
        System.out.println(((Promotion) event.getObject()).getPromotionId());
        promotion.setPromotionName(((Promotion) event.getObject()).getPromotionName());
        return promotion;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }
    
    
    
    }
      
    

