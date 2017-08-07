/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.business;

import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Shopkeeper;
import java.sql.SQLException;

/**
 *
 * @author a0120086r
 */
public interface ShopkeeperBusiness {

    public boolean validateShopkeeperLogin(Shopkeeper shopkeeper)throws CmmaAppException;

    public boolean checkPassword(String password, String password1)  throws CmmaAppException;

    public boolean updateShopkeeperPassword(Shopkeeper shopkeeper, String password1) throws CmmaAppException;
 public boolean registerValidate(Shopkeeper shopkeeper)throws CmmaAppException ;
   
    public String register(Shopkeeper shopkeeper)  throws CmmaAppException;
}
