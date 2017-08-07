/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.business.impl;

import com.ihpc.cmma.business.ShopkeeperBusiness;
import com.ihpc.cmma.dao.ShopkeeperDao;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Shopkeeper;
import java.sql.SQLException;

/**
 *
 * @author Sruthi
 */
public class ShopkeeperBusinessImpl implements ShopkeeperBusiness {

    private ShopkeeperDao dao;

    public void setDao(ShopkeeperDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean validateShopkeeperLogin(Shopkeeper shopkeeper) throws CmmaAppException {

        boolean isValidate = false;

        Shopkeeper sk = dao.getShopkeeperDetails(shopkeeper);
        System.out.println(shopkeeper.getShopkeeperPassword());
        if(sk!=null){
            if ((sk.getShopkeeperName().equals(shopkeeper.getShopkeeperName())) && (sk.getShopkeeperPassword().equals(shopkeeper.getShopkeeperPassword()))) {
            isValidate = true;
        } else {
            isValidate = false;
        }
        }
        

        return isValidate;

    }

    @Override
    public boolean checkPassword(String password, String password1) throws CmmaAppException {

        boolean isValidate;
        if (password.contentEquals(password1)) {
            isValidate = true;
        } else {
            isValidate = false;
        }

        return isValidate;
    }

    @Override
    public boolean updateShopkeeperPassword(Shopkeeper shopkeeper, String password1) throws CmmaAppException {

        boolean isValidate = false;

        Shopkeeper sk = dao.getShopkeeperDetails(shopkeeper);
        if(sk!=null){
            if (this.checkPassword(shopkeeper.getShopkeeperPassword(), password1) == true) {

            if ((sk.getShopkeeperName().equals(shopkeeper.getShopkeeperName())) && (sk.getEmailid().equalsIgnoreCase(shopkeeper.getEmailid()))) {


                dao.changePassword(sk, password1);

                isValidate = true;

            } else {
                isValidate = false;
            }

        }
        }
        
        return isValidate;
    }

    @Override
    public String  register(Shopkeeper shopkeeper) throws CmmaAppException {
       if( dao.register(shopkeeper)== true)
       {
       
         return "success";
         
       }
       else 
           return "false";
        
    }

    @Override
    public boolean registerValidate(Shopkeeper shopkeeper) throws CmmaAppException {
        
        if (dao.registerValidate(shopkeeper)==false)
            return false;
        else
            return true;
    }
}
