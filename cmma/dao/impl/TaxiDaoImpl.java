/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.dao.impl;

import com.ihpc.cmma.dao.TaxiDao;
import com.ihpc.cmma.dao.factory.PersistanceFactory;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Taxistand;
import com.ihpc.cmma.util.CmmaConstants;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 *
 * @author A0120035A
 */
public class TaxiDaoImpl implements TaxiDao {

    @Override
    public List<Taxistand> getTaxistands() throws CmmaAppException {
        try
        {
        EntityManager em = PersistanceFactory.getEntityManager();
        TypedQuery<Taxistand> query = em.createNamedQuery("Taxistand.findByStatus", Taxistand.class);
        query.setParameter("status", CmmaConstants.NUMBER_ONE);
        List<Taxistand> taxiList = query.getResultList();
        em.close();
        return taxiList;
        }
        catch (PersistenceException e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        } catch (Exception e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        }

    }

    @Override
    public boolean updateCrowdCount(Taxistand taxistand) throws CmmaAppException {
        try
        {
        Taxistand taxi = null;
        EntityManager em = PersistanceFactory.getEntityManager();
        em.getTransaction().begin();
        taxi = em.merge(taxistand);
        em.getTransaction().commit();
        em.close();
        if (taxi != null) {
            return true;
        } else {
            return false;
        }
        }
        catch (PersistenceException e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        } catch (Exception e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        }
    }

}
