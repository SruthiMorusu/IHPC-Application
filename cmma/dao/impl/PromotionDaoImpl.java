/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ihpc.cmma.dao.impl;

import com.ihpc.cmma.dao.PromotionDao;
import com.ihpc.cmma.dao.factory.PersistanceFactory;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Promotion;
import com.ihpc.cmma.util.CmmaConstants;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Sruthi
 */
public class PromotionDaoImpl implements PromotionDao {

    @Override
    public List<Promotion> getAllPromosDao()  throws CmmaAppException {
        try
        {
        EntityManager em = PersistanceFactory.getEntityManager();
        TypedQuery<Promotion> query = em.createNamedQuery("Promotion.findByStatus", Promotion.class);
        query.setParameter("status", CmmaConstants.NUMBER_ONE);
        List<Promotion> promotions = query.getResultList();
        em.close();
        return promotions;
        }
        catch (PersistenceException e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        } catch (Exception e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        }
    }

    @Override
    public List<Promotion> allPromotions(String ShopkeeperName)  throws CmmaAppException {
        try
        {
        EntityManager em = PersistanceFactory.getEntityManager();
          String q = "Select p from Promotion p where p.shopkeeperName= :shopkeeperName AND p.status= :Status";
          TypedQuery<Promotion> query = em.createQuery(q, Promotion.class);
          query.setParameter("shopkeeperName", ShopkeeperName);
          query.setParameter("Status", 1);
     //        TypedQuery<Promotion> query = em.createNamedQuery("select p from promotion p", Promotion.class);
        List<Promotion> promotions = query.getResultList();
        em.close();
        return promotions;
        }
        catch (PersistenceException e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        } catch (Exception e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        }
    }
    
    @Override
    public boolean saveAllPromotions(List<Promotion> allPromotions) throws CmmaAppException{
        try
        {
        EntityManager em = PersistanceFactory.getEntityManager();
        em.getTransaction().begin();
        for(Promotion promotion:allPromotions){
            em.persist(promotion);
        }
        em.getTransaction().commit();
        em.close();
        return true;
        }
        catch (PersistenceException e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        } catch (Exception e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        }
    }
    
     @Override
    public boolean insertPromotion(Promotion promotion)  throws CmmaAppException
    {
       try
       {
        EntityManager em = PersistanceFactory.getEntityManager();
        em.getTransaction().begin();
        System.out.println("Promotion name" + promotion.getPromotionName());
        em.persist(promotion);
        em.getTransaction().commit();
        em.close();
        return true;
       }
       catch (PersistenceException e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        } catch (Exception e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        }
    }

     @Override
    public boolean modifyPromotion(Promotion promotion)  throws CmmaAppException
    {
        try
        {
        EntityManager em=PersistanceFactory.getEntityManager();
         em.getTransaction().begin();
         em.merge(promotion);
         em.getTransaction().commit();
         em.close();
        return true;
        }
        catch (PersistenceException e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        } catch (Exception e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        }
    }
    
    @Override
    public boolean deletePromotion(Promotion promotion) throws CmmaAppException
    {    
        try
        {
      EntityManager em = PersistanceFactory.getEntityManager();
      em.getTransaction().begin();      
      promotion.setStatus(0);
      em.merge(promotion);
      em.getTransaction().commit();
      em.close();
    
      return true;
        }
        catch (PersistenceException e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        } catch (Exception e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        }
    }

     
      @Override
    public boolean promotionValidate(Promotion promotion)  throws CmmaAppException {
      try
      {
        EntityManager em = PersistanceFactory.getEntityManager();
        String q= "select p from Promotion p where p.promotionName= :PromotionName";         
        TypedQuery<Promotion> query = em.createQuery(q, Promotion.class);
        query.setParameter("PromotionName", promotion.getPromotionName());
          return !query.getResultList().isEmpty();
       
      }
      catch (PersistenceException e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        } catch (Exception e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        }
    }
}
