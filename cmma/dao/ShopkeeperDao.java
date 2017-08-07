/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.dao;

import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Shopkeeper;


/**
 *
 * @author a0120086r
 */
public interface ShopkeeperDao {
    
    public Shopkeeper getShopkeeperDetails(Shopkeeper shopkeeper)throws CmmaAppException;
    public boolean register(Shopkeeper shopkeeper) throws CmmaAppException;
    public Shopkeeper changePassword(Shopkeeper shopkeeper,String password) throws CmmaAppException;
    public boolean registerValidate(Shopkeeper shopkeeper) throws CmmaAppException;
}
