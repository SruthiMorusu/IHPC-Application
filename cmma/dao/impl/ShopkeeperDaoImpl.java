/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.dao.impl;

import com.ihpc.cmma.dao.ShopkeeperDao;
import com.ihpc.cmma.dao.factory.PersistanceFactory;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Shopkeeper;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 *
 * @author a0120086r
 */
public class ShopkeeperDaoImpl implements ShopkeeperDao {


    /**
     *
     * @param shopkeeper
     * @return
     * @throws com.ihpc.cmma.exception.CmmaAppException
     * @throws ClassNotFoundException
     */
    @Override
    public Shopkeeper getShopkeeperDetails(Shopkeeper shopkeeper) throws CmmaAppException{
        try {
            EntityManager em = PersistanceFactory.getEntityManager();
        String q = "Select s from Shopkeeper s where s.shopkeeperName=:Shopkeeper";
        TypedQuery<Shopkeeper> query = em.createQuery(q, Shopkeeper.class);
        query.setParameter("Shopkeeper", shopkeeper.getShopkeeperName());
        if (query.getResultList().isEmpty()) {
            return null;
        } else {
            return query.getResultList().get(0);
        }
        }catch(PersistenceException pe){
            throw new CmmaAppException("JPA Entity Exception", pe);
        }
        catch (Exception e) {
            throw new CmmaAppException("Dao Exception", e);
        }
        

    }

    public Shopkeeper changePassword(Shopkeeper shopkeeper, String password) throws CmmaAppException {

        try{
        EntityManager em = PersistanceFactory.getEntityManager();
//     skp=em.find(Shopkeeper.class, shopkeeper.getShopkeeperId());
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        shopkeeper.setShopkeeperPassword(password);
        em.merge(shopkeeper);
        tx.commit();
        em.close();
        return shopkeeper;
        }
        catch(PersistenceException pe){
            throw new CmmaAppException("JPA Entity Exception", pe);
        }
        catch (Exception e) {
            throw new CmmaAppException("Dao Exception", e);
        }
    }

    @Override
    public boolean register(Shopkeeper shopkeeper) throws CmmaAppException{
try
{
        EntityManager em = PersistanceFactory.getEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(shopkeeper);
        tx.commit();
        em.close();
        return true;
}
catch(PersistenceException pe){
            throw new CmmaAppException("JPA Entity Exception", pe);
        }
        catch (Exception e) {
            throw new CmmaAppException("Dao Exception", e);
        }
    }

    @Override
    public boolean registerValidate(Shopkeeper shopkeeper) throws CmmaAppException{
        try{
        EntityManager em = PersistanceFactory.getEntityManager();
        String q = "Select s from Shopkeeper s where s.shopkeeperName=:Shopkeeper or s.emailid= :EmailId";
        TypedQuery<Shopkeeper> query = em.createQuery(q, Shopkeeper.class);
        query.setParameter("Shopkeeper", shopkeeper.getShopkeeperName());
        query.setParameter("EmailId", shopkeeper.getEmailid());
        if (query.getResultList().isEmpty()) {
            System.out.println("pass");
            return true;

        } else {
            System.out.println("fail");
            return false;

        }
    }
    
    catch(PersistenceException pe){
            throw new CmmaAppException("JPA Entity Exception", pe);
        }
        catch (Exception e) {
            throw new CmmaAppException("Dao Exception", e);
        }
  
    }

}
