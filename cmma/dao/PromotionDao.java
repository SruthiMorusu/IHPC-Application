/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ihpc.cmma.dao;

import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Promotion;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Sruthi
 */
public interface PromotionDao {
    public List<Promotion> getAllPromosDao()  throws CmmaAppException;
    public List<Promotion> allPromotions(String ShopkeeperName)  throws CmmaAppException;
    public boolean saveAllPromotions(List<Promotion> allPromotions) throws CmmaAppException;
    public boolean insertPromotion(Promotion promotion)  throws CmmaAppException;
    public boolean modifyPromotion(Promotion promotion)  throws CmmaAppException;
    public boolean deletePromotion(Promotion promotion)  throws CmmaAppException;
    public boolean promotionValidate(Promotion promotion) throws CmmaAppException;
}
