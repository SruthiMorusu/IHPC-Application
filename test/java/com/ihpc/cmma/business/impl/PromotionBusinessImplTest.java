/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.business.impl;

import com.ihpc.cmma.dao.PromotionDao;
import com.ihpc.cmma.dao.impl.PromotionDaoImpl;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Promotion;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.primefaces.model.DefaultUploadedFile;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Sruthi
 */
@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = {"classpath:applicationContext.xml" }) 

public class PromotionBusinessImplTest {
    
    @Autowired
    private PromotionDao promotionDao;
    private PromotionBusinessImpl promotionBusinessImpl;
    private Promotion promotion;
    private Date date;
    private Date date1;
    
    
    public PromotionBusinessImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws ParseException {
        promotion = new Promotion();
        promotionBusinessImpl= new PromotionBusinessImpl();
        promotionBusinessImpl.setPromotionDao(promotionDao);
        promotion.setFile(null);   
        promotion.setPromotionName("Free Smoothie");
        promotion.setPromotionDescription("Get a smoothie with every purchase of 10$");
        String date_s = "24-04-2015";
        SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
        date = dt.parse(date_s);
        promotion.setPromotionStartDate(date);
        String date_e= "27-04-2015";
        date1= dt.parse(date_e);
        promotion.setPromotionEndDate(date1);
       
        
    }
    
    @After
    public void tearDown() throws CmmaAppException {
       promotionBusinessImpl.deletePromotionBusiness(promotion);
       promotion=null;
       promotionBusinessImpl=null;
    
    }

    /**
     * Test of setPromotionDao method, of class PromotionBusinessImpl.
     */
    //@Test
    public void testSetPromotionDao() {
         System.out.println("setPromotionDao");
        assertTrue(promotionDao!=null);
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of getAllPromosBusiness method, of class PromotionBusinessImpl.
     */
    //@Test
    public void testGetAllPromosBusiness() throws Exception {
        System.out.println("getAllPromosBusiness");           
        List<Promotion> result = promotionBusinessImpl.getAllPromosBusiness();
        assertTrue(!result.isEmpty());
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of createPromotionBusiness method, of class PromotionBusinessImpl.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreatePromotionBusiness() throws Exception {
        
        String result= promotionBusinessImpl.createPromotionBusiness(promotion);
        assertEquals(result, "success");

    }

    /**
     * Test of modifyPromotionBusiness method, of class PromotionBusinessImpl.
     */
    @Test
    public void testModifyPromotionBusiness() throws Exception {
        promotion.setPromotionName("Smooth smoothie!");
        Boolean result= promotionBusinessImpl.modifyPromotionBusiness(promotion);
        assertEquals(result, promotionDao.modifyPromotion(promotion));
        promotion.setShopkeeperName("Free Smoothie");

    }

    /**
     * Test of deletePromotionBusiness method, of class PromotionBusinessImpl.
     */
    @Test
    public void testDeletePromotionBusiness() throws Exception {
        Boolean result= promotionBusinessImpl.deletePromotionBusiness(promotion);
        assertEquals(result, promotionDao.deletePromotion(promotion));

    }

    /**
     * Test of allPromotions method, of class PromotionBusinessImpl.
     */
    @Test
    public void testAllPromotions() throws Exception {
       
        String shopkeeperName= "anu";     
       List<Promotion> expResult = null;
       expResult= promotionBusinessImpl.allPromotions(shopkeeperName);
       for(Promotion promo:expResult){
           System.out.println(promo);
       }
        assertTrue(expResult!=null);
//        List<Promotion> result = promotionBusinessImpl.allPromotions("Anu");
//        assertTrue(!result.isEmpty());
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of promotionValidate method, of class PromotionBusinessImpl.
     */
    @Test
    public void testPromotionValidate() throws Exception {
        Boolean result= promotionBusinessImpl.promotionValidate(promotion);
        assertEquals(result, promotionDao.promotionValidate(promotion));

    }
    /**
     * Test of isValidateDateRange method, of class PromotionBusinessImpl.
     */
    @Test
    public void testIsValidateDateRange() throws Exception {
        Boolean result = promotionBusinessImpl.isValidateDateRange(date, date1);
        assertEquals(result, true);

    }
    
}

