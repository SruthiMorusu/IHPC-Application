/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ihpc.cmma.business;

import com.ihpc.cmma.exception.CmmaException;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Promotion;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Sruthi
 */
public interface PromotionBusiness {

    public List<Promotion> getAllPromosBusiness() throws CmmaAppException,IOException;
    public List<Promotion> allPromotions(String shopkeeperName) throws CmmaAppException,IOException;
    public String createPromotionBusiness(Promotion promotion) throws CmmaAppException,IOException;
    public boolean promotionValidate(Promotion promotion) throws CmmaAppException;
    public boolean modifyPromotionBusiness(Promotion promotion) throws CmmaAppException;
    public boolean deletePromotionBusiness(Promotion promotion) throws CmmaAppException;
    public boolean isValidateDateRange(Date startDate, Date endDate) throws CmmaException; 

 

}
