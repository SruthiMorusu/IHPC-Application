/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.business.impl;

import com.ihpc.cmma.dao.SportsHubDao;
import com.ihpc.cmma.model.SportsHubGate;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sruthi
 */
public class SportsHubBusinessImplTest {
    
    public SportsHubBusinessImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setHubDao method, of class SportsHubBusinessImpl.
     */
    @Test
    public void testSetHubDao() {
        System.out.println("setHubDao");
        SportsHubDao hubDao = null;
        SportsHubBusinessImpl instance = new SportsHubBusinessImpl();
        instance.setHubDao(hubDao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllGatesBusiness method, of class SportsHubBusinessImpl.
     */
    @Test
    public void testGetAllGatesBusiness() throws Exception {
        System.out.println("getAllGatesBusiness");
        SportsHubBusinessImpl instance = new SportsHubBusinessImpl();
        List<SportsHubGate> expResult = null;
        List<SportsHubGate> result = instance.getAllGatesBusiness();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCrowdBusiness method, of class SportsHubBusinessImpl.
     */
    @Test
    public void testUpdateCrowdBusiness() throws Exception {
        System.out.println("updateCrowdBusiness");
        SportsHubBusinessImpl instance = new SportsHubBusinessImpl();
        Integer expResult = null;
        Integer result = instance.updateCrowdBusiness();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
