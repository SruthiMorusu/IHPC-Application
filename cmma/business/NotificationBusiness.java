/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.business;

import com.ihpc.cmma.exception.CmmaException;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Event;
import com.ihpc.cmma.model.MobileToken;
import com.ihpc.cmma.model.Promotion;

/**
 *
 * @author Sruthi
 */
public interface NotificationBusiness {
    
    public void registerMobileBusiness(MobileToken token) throws CmmaAppException;
    public boolean notifyPromotion(Promotion promotion) throws CmmaAppException;
    public boolean notifyEvent(Event event)throws CmmaAppException;
}
