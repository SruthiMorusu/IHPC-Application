/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.dao.factory;

import com.ihpc.cmma.util.PropertyUtil;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Sruthi
 */
@ApplicationScoped
public class MongoDbFactory {

    private static MongoClient client;
    private static DB mongoDb;
 
    public static DB getMongoDb() throws UnknownHostException {
        try {
            if (client == null) {
                
               //String add = PropertyLoader.getProperty("mongoAddress");
                client = new MongoClient(PropertyUtil.getPropery("mongo_address"), Integer.parseInt(PropertyUtil.getPropery("mongo_port")));            }
            if (mongoDb == null) {
                
                mongoDb = client.getDB("IHPC");
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(MongoDbFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (IOException ex) {
            Logger.getLogger(MongoDbFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mongoDb;
    }    
}
