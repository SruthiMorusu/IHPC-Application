/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.business.impl;

import com.ihpc.cmma.dao.BusStandDao;
import com.ihpc.cmma.model.BusStand;
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
public class BusStandBusinessImplTest {
    
    public BusStandBusinessImplTest() {
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
     * Test of setStandDao method, of class BusStandBusinessImpl.
     */
    @Test
    public void testSetStandDao() {
        System.out.println("setStandDao");
        BusStandDao standDao = null;
        BusStandBusinessImpl instance = new BusStandBusinessImpl();
        instance.setStandDao(standDao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllBusBusiness method, of class BusStandBusinessImpl.
     */
    @Test
    public void testGetAllBusBusiness() throws Exception {
        System.out.println("getAllBusBusiness");
        BusStandBusinessImpl instance = new BusStandBusinessImpl();
        List<BusStand> expResult = null;
        List<BusStand> result = instance.getAllBusBusiness();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
