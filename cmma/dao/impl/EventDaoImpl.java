/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ihpc.cmma.dao.impl;

import com.ihpc.cmma.dao.EventDao;
import com.ihpc.cmma.dao.factory.PersistanceFactory;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Event;
import com.ihpc.cmma.util.CmmaConstants;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Sruthi
 */
public class EventDaoImpl implements EventDao{

    @Override
    public List<Event> getAllEvents()throws CmmaAppException {
        List<Event> events = null;
        try {
            EntityManager em = PersistanceFactory.getEntityManager();
            TypedQuery<Event> query = em.createNamedQuery("Event.findByStatus", Event.class);
            query.setParameter("status", CmmaConstants.NUMBER_ONE);
            events = query.getResultList();
            em.close();
        } catch (PersistenceException e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        } catch (Exception e) {
            throw new CmmaAppException("JPA Exception", e);
        }
        return events;
    }

    @Override
    public boolean saveAllEvents(List<Event> allEvents) throws CmmaAppException{
        try {
            EntityManager em = PersistanceFactory.getEntityManager();
            em.getTransaction().begin();
            for (Event event : allEvents) {
                em.persist(event);
            }
            em.getTransaction().commit();
            em.close();
        } catch (PersistenceException e) {
            throw new CmmaAppException("JPA Persistance Exception", e); 
       } catch (Exception e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        }

        return true;
    }
    
    @Override
    public boolean insertEvent(Event event) throws CmmaAppException
    {
        try
        {
        System.out.println("SGGGGGGGGG" +event.getEventName());
        EntityManager em = PersistanceFactory.getEntityManager();
        em.getTransaction().begin();
        em.persist(event);
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
    public boolean modifyEvent(Event event) throws CmmaAppException
    {
        try
        {
        EntityManager em=PersistanceFactory.getEntityManager();
         em.getTransaction().begin();
         em.merge(event);
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
    public List<Event> allEvents(String shopkeeperName)  throws CmmaAppException{
        try
        {
        EntityManager em = PersistanceFactory.getEntityManager();
          String q = "Select p from Event p where p.shopkeeperName= :shopkeeperName AND p.status= :Status ";
          TypedQuery<Event> query = em.createQuery(q, Event.class);
       query.setParameter("shopkeeperName", shopkeeperName);
         query.setParameter("Status", 1);
        List<Event> events = query.getResultList();
        em.close();
        return events;
        }
        catch (PersistenceException e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        } catch (Exception e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        }
    }
    
          @Override
    public boolean validateEvent(Event event)  throws CmmaAppException{
      
        try{
        EntityManager em = PersistanceFactory.getEntityManager();
        String q= "select e from Event e where e.eventName= :EventName";         
        TypedQuery<Event> query = em.createQuery(q, Event.class);
        query.setParameter("EventName", event.getEventName());
        return !query.getResultList().isEmpty();
        }
        catch (PersistenceException e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        } catch (Exception e) {
            throw new CmmaAppException("JPA Persistance Exception", e);
        }
    }
    
    @Override
    public boolean deleteEvent(Event event) throws CmmaAppException
    {
        try
        {
       EntityManager em = PersistanceFactory.getEntityManager();
        em.getTransaction().begin();        
        event.setStatus(0);
        em.merge(event);
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
    }

