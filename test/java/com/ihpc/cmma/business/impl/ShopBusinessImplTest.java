/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.business.impl;

import com.ihpc.cmma.dao.ShopDao;
import com.ihpc.cmma.model.Category;
import com.ihpc.cmma.model.Shop;
import java.util.List;
import java.util.Map;
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
public class ShopBusinessImplTest {
    
    public ShopBusinessImplTest() {
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
     * Test of setShopDao method, of class ShopBusinessImpl.
     */
    @Test
    public void testSetShopDao() {
        System.out.println("setShopDao");
        ShopDao shopDao = null;
        ShopBusinessImpl instance = new ShopBusinessImpl();
        instance.setShopDao(shopDao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getShopsBusiness method, of class ShopBusinessImpl.
     */
    @Test
    public void testGetShopsBusiness() throws Exception {
        System.out.println("getShopsBusiness");
        ShopBusinessImpl instance = new ShopBusinessImpl();
        List<Shop> expResult = null;
        List<Shop> result = instance.getShopsBusiness();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategotyBusiness method, of class ShopBusinessImpl.
     */
    @Test
    public void testGetCategotyBusiness() throws Exception {
        System.out.println("getCategotyBusiness");
        ShopBusinessImpl instance = new ShopBusinessImpl();
        List<Category> expResult = null;
        List<Category> result = instance.getCategotyBusiness();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategotyBykeyBusiness method, of class ShopBusinessImpl.
     */
    @Test
    public void testGetCategotyBykeyBusiness() throws Exception {
        System.out.println("getCategotyBykeyBusiness");
        ShopBusinessImpl instance = new ShopBusinessImpl();
        Map<String, List<Shop>> expResult = null;
        Map<String, List<Shop>> result = instance.getCategotyBykeyBusiness();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
