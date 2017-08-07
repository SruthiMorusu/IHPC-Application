/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.business.impl;

import com.ihpc.cmma.dao.TaxiDao;
import com.ihpc.cmma.model.Taxistand;
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
public class TaxiBusinessImplTest {
    
    public TaxiBusinessImplTest() {
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
     * Test of setTaxiDao method, of class TaxiBusinessImpl.
     */
    @Test
    public void testSetTaxiDao() {
        System.out.println("setTaxiDao");
        TaxiDao taxiDao = null;
        TaxiBusinessImpl instance = new TaxiBusinessImpl();
        instance.setTaxiDao(taxiDao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTaxiStandBusiness method, of class TaxiBusinessImpl.
     */
    @Test
    public void testGetTaxiStandBusiness() throws Exception {
        System.out.println("getTaxiStandBusiness");
        TaxiBusinessImpl instance = new TaxiBusinessImpl();
        List<Taxistand> expResult = null;
        List<Taxistand> result = instance.getTaxiStandBusiness();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCrowdBusiness method, of class TaxiBusinessImpl.
     */
    @Test
    public void testUpdateCrowdBusiness() throws Exception {
        System.out.println("updateCrowdBusiness");
        TaxiBusinessImpl instance = new TaxiBusinessImpl();
        Integer expResult = null;
        Integer result = instance.updateCrowdBusiness();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
