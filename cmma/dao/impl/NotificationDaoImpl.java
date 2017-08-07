/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.dao.impl;

import com.ihpc.cmma.dao.NotificationDao;
import com.ihpc.cmma.dao.factory.PersistanceFactory;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.MobileToken;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Sruthi
 */
public class NotificationDaoImpl implements NotificationDao{
    @Override
    public void registerMobile(MobileToken token) throws CmmaAppException{
        try
        {
        EntityManager em = PersistanceFactory.getEntityManager();
        em.getTransaction().begin();
        em.persist(token);
        em.getTransaction().commit();
        em.close();
        }
        catch (PersistenceException e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        } catch (Exception e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        }
    }

    @Override
    public List<MobileToken> getAllRegisteredMobiles() throws CmmaAppException {
        TypedQuery<MobileToken> query ;
        try
        {
        EntityManager em = PersistanceFactory.getEntityManager();
         query = em.createNamedQuery("MobileToken.findAll", MobileToken.class);
        }
        catch (PersistenceException e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        } catch (Exception e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        }
        return query.getResultList();
    }
}
