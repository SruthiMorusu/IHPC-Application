/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.business.impl;

import com.ihpc.cmma.dao.VenueDao;
import com.ihpc.cmma.model.MallCrowd;
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
public class VenueBusinessImplTest {
    
    public VenueBusinessImplTest() {
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
     * Test of setVenueDao method, of class VenueBusinessImpl.
     */
    @Test
    public void testSetVenueDao() {
        System.out.println("setVenueDao");
        VenueDao venueDao = null;
        VenueBusinessImpl instance = new VenueBusinessImpl();
        instance.setVenueDao(venueDao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVenueCrowd method, of class VenueBusinessImpl.
     */
    @Test
    public void testGetVenueCrowd() throws Exception {
        System.out.println("getVenueCrowd");
        String mallName = "";
        VenueBusinessImpl instance = new VenueBusinessImpl();
        MallCrowd expResult = null;
        MallCrowd result = instance.getVenueCrowd(mallName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateVenueCrowdBusiness method, of class VenueBusinessImpl.
     */
    @Test
    public void testUpdateVenueCrowdBusiness() throws Exception {
        System.out.println("updateVenueCrowdBusiness");
        VenueBusinessImpl instance = new VenueBusinessImpl();
        Integer expResult = null;
        Integer result = instance.updateVenueCrowdBusiness();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
