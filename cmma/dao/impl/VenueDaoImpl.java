/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.dao.impl;

import com.ihpc.cmma.dao.VenueDao;
import com.ihpc.cmma.dao.factory.PersistanceFactory;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Camera;
import com.ihpc.cmma.model.MallCrowd;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 *
 * @author sruthi

 */
public class VenueDaoImpl implements VenueDao {

    @Override
    public MallCrowd getVenueCrowd(String mallName) throws CmmaAppException {
        try
        {
        MallCrowd mallcrowd = null;
        EntityManager em = PersistanceFactory.getEntityManager();
        // Read the existing entries and write to console
        String queryString = "SELECT m FROM MallCrowd m WHERE m.mallName = :mallName";
        TypedQuery<MallCrowd> query = em.createQuery(queryString, MallCrowd.class);
        query.setParameter("mallName", mallName);
        mallcrowd = query.getResultList().get(0);
        em.close();

    return mallcrowd;
        }
        catch (PersistenceException e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        } catch (Exception e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        }
    }

    @Override
    public boolean updateVenueCrowdCount(Camera camera) throws CmmaAppException {
      try
      {
        Camera toUpdate = null;
        EntityManager em = PersistanceFactory.getEntityManager();
        em.getTransaction().begin();
        toUpdate = em.merge(camera);
        em.getTransaction().commit();
        em.close();
        if (camera != null) {
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

    @Override
    //Method to retrieve all the cameras
    
    public List<Camera> getCameras() throws CmmaAppException {
        try
        {
        EntityManager em = PersistanceFactory.getEntityManager();
        TypedQuery<Camera> query = em.createNamedQuery("Camera.findAll", Camera.class);
        List<Camera> camList = query.getResultList();
        em.close();
        return camList;
        }
        catch (PersistenceException e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        } catch (Exception e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        }
    }
    
  }

    

