/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ihpc.cmma.dao.impl;

import com.ihpc.cmma.dao.ShopDao;
import com.ihpc.cmma.dao.factory.MongoDbFactory;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Shop;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
/**
 *
 * @author Sruthi
 */
public class ShopDaoImpl implements ShopDao{
    private DB mongoDb;
  private Connection conn;
    @Override
    public List<Shop> getAllShops() throws CmmaAppException{
        try {
            List<Shop> shops = new ArrayList<>();
            
            
            mongoDb = MongoDbFactory.getMongoDb();

            BasicDBObject allQuery = new BasicDBObject();
            //BasicDBObject fields = new BasicDBObject();
            BasicDBObject fields = new BasicDBObject("docs",true).append("_id",false);
            DBCursor docs = mongoDb.getCollection("suntec").find(allQuery,fields);
            DBObject first = docs.next();
            List<DBObject> list = (List<DBObject>) first.get("docs");
            
            for(DBObject first1:list) {
                if (first1.get("category") != null && first1.get("topCategory")!=null && first1.get("companyName")!=null) {
                    Shop shop = new Shop();
                    shop.setCompanyName(first1.get("companyName").toString());
                    shop.setAddress(first1.get("address").toString());
                    shop.setBuildingName(first1.get("placeBuildingName")!=null?first1.get("placeBuildingName").toString():"");
                    shop.setCategoryName(first1.get("topCategory").toString());
                    shop.setLatLong(first1.get("latLng").toString());
                    shop.setType(first1.get("type").toString());
                    shop.setThemes((List<String>) first1.get("placeTheme"));
                    shop.setLogoId(first1.get("logoId")!=null?first1.get("logoId").toString():"");
                    
                    shops.add(shop);
                }
                
            }
            
            return shops;
        } catch (UnknownHostException | MongoException ex) {
            throw new CmmaAppException("Mongo Exception", ex);
        }
    }

    
    
}
