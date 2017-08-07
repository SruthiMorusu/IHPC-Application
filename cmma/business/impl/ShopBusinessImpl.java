/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.business.impl;

import com.ihpc.cmma.business.ShopBusiness;
import com.ihpc.cmma.dao.ShopDao;
import com.ihpc.cmma.exception.CmmaMongoException;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Category;
import com.ihpc.cmma.model.Shop;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Sruthi
 */
public class ShopBusinessImpl implements ShopBusiness {

    private ShopDao shopDao;

    public void setShopDao(ShopDao shopDao) {
        this.shopDao = shopDao;
    }

    @Override
    public List<Shop> getShopsBusiness() throws CmmaAppException{
        return shopDao.getAllShops();
    }

    @Override
    public List<Category> getCategotyBusiness() throws CmmaAppException{
        List<Category> cataList = new ArrayList<>();
        Map<String, List<Shop>> catMap = this.getCategotyBykeyBusiness();
        for(Entry<String, List<Shop>> entry:catMap.entrySet()){
            Category category = new Category();
            category.setCategoryName(entry.getKey());
            category.setShopList(entry.getValue());
            cataList.add(category);
        }
        return cataList;
    }
    
    @Override
    public Map<String, List<Shop>> getCategotyBykeyBusiness() throws CmmaAppException {

        List<Shop> shopList = shopDao.getAllShops();
        Map<String, List<Shop>> cataMap = new HashMap<>();
        for (Shop s : shopList) {
            if (cataMap.containsKey(s.getCategoryName())) {
                List<Shop> shops = cataMap.get(s.getCategoryName());
                shops.add(s);
            } else {
                List<Shop> shops = new ArrayList<>();
                shops.add(s);
                cataMap.put(s.getCategoryName(), shops);
            }
        }
        return cataMap;
    }
}
