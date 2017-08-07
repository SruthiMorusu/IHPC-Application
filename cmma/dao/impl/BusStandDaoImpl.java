/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.dao.impl;

import com.ihpc.cmma.dao.BusStandDao;
import com.ihpc.cmma.dao.factory.MongoDbFactory;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.BusStand;
import com.ihpc.cmma.util.CmmaConstants;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author A0120035A
 */
public class BusStandDaoImpl implements BusStandDao{
    private DB mongoDb;
    private Connection conn;
    @Override
    public List<BusStand> getAllBusStops() throws CmmaAppException{
        List<BusStand> stands = new ArrayList<>();
        try {
            mongoDb = MongoDbFactory.getMongoDb();
            BasicDBObject allQuery = new BasicDBObject();
            //BasicDBObject fields = new BasicDBObject();
            DBCursor busService = mongoDb.getCollection("SG_BusServices").find();
            DBObject serviceObj = busService.next();
            BasicDBObject fields = new BasicDBObject("docs",true).append("_id",false);
            DBCursor docs = mongoDb.getCollection("SG_BusStops").find(allQuery,fields);
            DBObject first = docs.next();
            List<DBObject> list = (List<DBObject>) first.get("docs");
            
           for(DBObject first1:list) {  
                    if (first1.get("no") != null && first1.get("name")!=null) {
                        BusStand stand = new BusStand();
                        stand.setLattitude(first1.get("lat")!=null?first1.get("lat").toString():CmmaConstants.EMPTY);
                        stand.setLongitude(first1.get("lng")!=null?first1.get("lng").toString():CmmaConstants.EMPTY);
                        stand.setStopCode(first1.get("no").toString());
                        stand.setStopName(first1.get("name").toString());
                        String code = first1.get("no").toString();
                        stand.setBusServices((List<String>) serviceObj.get(code));
                        stands.add(stand);
                    }
 
            }
        } catch (UnknownHostException ex) {
            throw new CmmaAppException("mongoException", ex);
        }
        catch(MongoException me)
        {
            throw new CmmaAppException("Mongo Exception", me);
        }
               
        return stands;
    }
}
