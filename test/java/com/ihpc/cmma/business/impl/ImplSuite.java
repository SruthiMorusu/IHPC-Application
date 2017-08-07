/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.business.impl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Sruthi
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({com.ihpc.cmma.business.impl.SportsHubBusinessImplTest.class, com.ihpc.cmma.business.impl.NotificationBusinessImplTest.class, com.ihpc.cmma.business.impl.PromotionBusinessImplTest.class, com.ihpc.cmma.business.impl.ShopBusinessImplTest.class, com.ihpc.cmma.business.impl.BusStandBusinessImplTest.class, com.ihpc.cmma.business.impl.ShopkeeperBusinessImplTest.class, com.ihpc.cmma.business.impl.VenueBusinessImplTest.class, com.ihpc.cmma.business.impl.EventBusinessImplTest.class, com.ihpc.cmma.business.impl.TaxiBusinessImplTest.class})
public class ImplSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
