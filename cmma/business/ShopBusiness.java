/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ihpc.cmma.business;

import com.ihpc.cmma.exception.CmmaException;
import com.ihpc.cmma.exception.CmmaMongoException;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Category;
import com.ihpc.cmma.model.Shop;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Sruthi
 */
public interface ShopBusiness {
   
   public List<Shop> getShopsBusiness() throws CmmaAppException;
   public Map<String,List<Shop>> getCategotyBykeyBusiness() throws CmmaAppException;
   public List<Category> getCategotyBusiness() throws CmmaAppException;
}
