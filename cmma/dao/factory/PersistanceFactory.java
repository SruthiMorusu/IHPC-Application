/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ihpc.cmma.dao.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Sruthi
 */
public class PersistanceFactory {
   

    private static final EntityManagerFactory emf;
    

    static {
        emf = Persistence.createEntityManagerFactory("mysql_cmma");
        
    }

    public static EntityManager getEntityManager() {

        EntityManager em = emf.createEntityManager();
            // set your flush mode here

        return em;
    }

   
}
