/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.dao.impl;

import com.ihpc.cmma.dao.SportsHubDao;
import com.ihpc.cmma.dao.factory.PersistanceFactory;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.SportsHubGate;
import com.ihpc.cmma.util.CmmaConstants;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 *
 * @author sruthi
 */
public class SportsHubDaoImpl implements SportsHubDao{

    @Override
    public List<SportsHubGate> getAllGates() throws CmmaAppException {
        try
        {
        EntityManager em = PersistanceFactory.getEntityManager();
        TypedQuery<SportsHubGate> query = em.createNamedQuery("SportsHubGate.findByStatus", SportsHubGate.class);
        query.setParameter("status", CmmaConstants.NUMBER_ONE);
        List<SportsHubGate> gateList = query.getResultList();
        em.close();
        return gateList;
        }
        catch (PersistenceException e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        } catch (Exception e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        }
    }

    @Override
    public boolean updateSportshubCrowdCount(SportsHubGate shGate) throws CmmaAppException {
        try
        {
        SportsHubGate toUpdate = null;
        EntityManager em = PersistanceFactory.getEntityManager();
        em.getTransaction().begin();
        toUpdate = em.merge(shGate);
        em.getTransaction().commit();
        em.close();
        if (shGate != null) {
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
