/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.business.impl;

import com.ihpc.cmma.dao.NotificationDao;
import com.ihpc.cmma.model.Event;
import com.ihpc.cmma.model.MobileToken;
import com.ihpc.cmma.model.Promotion;
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
public class NotificationBusinessImplTest {
    
    public NotificationBusinessImplTest() {
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
     * Test of registerMobileBusiness method, of class NotificationBusinessImpl.
     */
    @Test
    public void testRegisterMobileBusiness() throws Exception {
        System.out.println("registerMobileBusiness");
        MobileToken token = null;
        NotificationBusinessImpl instance = new NotificationBusinessImpl();
        instance.registerMobileBusiness(token);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of notifyPromotion method, of class NotificationBusinessImpl.
     */
    @Test
    public void testNotifyPromotion() throws Exception {
        System.out.println("notifyPromotion");
        Promotion promotion = null;
        NotificationBusinessImpl instance = new NotificationBusinessImpl();
        boolean expResult = false;
        boolean result = instance.notifyPromotion(promotion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of notifyEvent method, of class NotificationBusinessImpl.
     */
    @Test
    public void testNotifyEvent() throws Exception {
        System.out.println("notifyEvent");
        Event event = null;
        NotificationBusinessImpl instance = new NotificationBusinessImpl();
        boolean expResult = false;
        boolean result = instance.notifyEvent(event);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNotificationDao method, of class NotificationBusinessImpl.
     */
    @Test
    public void testGetNotificationDao() {
        System.out.println("getNotificationDao");
        NotificationBusinessImpl instance = new NotificationBusinessImpl();
        NotificationDao expResult = null;
        NotificationDao result = instance.getNotificationDao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNotificationDao method, of class NotificationBusinessImpl.
     */
    @Test
    public void testSetNotificationDao() {
        System.out.println("setNotificationDao");
        NotificationDao notificationDao = null;
        NotificationBusinessImpl instance = new NotificationBusinessImpl();
        instance.setNotificationDao(notificationDao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
