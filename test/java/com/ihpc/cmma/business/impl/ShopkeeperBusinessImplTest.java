/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.business.impl;

import com.ihpc.cmma.dao.ShopkeeperDao;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Shopkeeper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Sruthi
 */
@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = {"classpath:applicationContext.xml" }) 

public class ShopkeeperBusinessImplTest {
    
    @Autowired
    private ShopkeeperDao dao;
    private Shopkeeper shopkeeper;
    private ShopkeeperBusinessImpl shopkeeperBusinessImpl;

    public void setDao(ShopkeeperDao dao) {
        this.dao = dao;
    }

    
    
    public ShopkeeperBusinessImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws CmmaAppException {
        shopkeeperBusinessImpl = new ShopkeeperBusinessImpl();
        shopkeeperBusinessImpl.setDao(dao);
        shopkeeper = new Shopkeeper();
        shopkeeper.setCompanyName("candy shop");
        shopkeeper.setConfimPassword("password123");
        shopkeeper.setEmailid("a@gmail.com");
        shopkeeper.setShopNumber("123");
        shopkeeper.setShopkeeperName("anu");
        shopkeeper.setShopkeeperPassword("a123");
        shopkeeper = dao.getShopkeeperDetails(shopkeeper);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setDao method, of class ShopkeeperBusinessImpl.
     */
    //@Test
    public void testSetDao() {
        System.out.println("setDao");
        ShopkeeperDao dao = null;
        ShopkeeperBusinessImpl instance = new ShopkeeperBusinessImpl();
        instance.setDao(dao);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(instance != null);
    }

    /**
     * Test of validateShopkeeperLogin method, of class ShopkeeperBusinessImpl.
     */
    @Test
    public void testValidateShopkeeperLogin() throws Exception {
        Shopkeeper shopkeeper1 = new Shopkeeper();
        shopkeeper.setShopkeeperName("Preeti");
        shopkeeper.setShopkeeperPassword("preeti123");
        Assert.assertEquals(true,shopkeeperBusinessImpl.validateShopkeeperLogin(shopkeeper) ); 
        
    }

    /**
     * Test of checkPassword method, of class ShopkeeperBusinessImpl.
     */
    @Test
    public void testCheckPassword() throws Exception {
        
        String password = "ram123";
        String password1 = "ram123";
        
        Assert.assertEquals(true,shopkeeperBusinessImpl.checkPassword(password, password1) ); 
        
    }

    /**
     * Test of updateShopkeeperPassword method, of class ShopkeeperBusinessImpl.
     */
    
    public void testUpdateShopkeeperPassword() throws Exception {
       Assert.assertEquals(true,shopkeeperBusinessImpl.updateShopkeeperPassword(shopkeeper, "Test123TT") );  
     
    }

    /**
     * Test of register method, of class ShopkeeperBusinessImpl.
     */
    @Test
    public void testRegister() throws Exception {
       
        Assert.assertEquals("success",shopkeeperBusinessImpl.register(shopkeeper));
    }   
         
        
    
    /**
     * Test of registerValidate method, of class ShopkeeperBusinessImpl.
     */
    //@Test
    public void testRegisterValidate() throws Exception {
        Assert.assertEquals(true,shopkeeperBusinessImpl.registerValidate(shopkeeper));
        }
        
        
    }
    

