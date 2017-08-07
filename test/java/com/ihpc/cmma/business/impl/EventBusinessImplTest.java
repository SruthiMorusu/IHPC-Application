/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.business.impl;

import com.ihpc.cmma.dao.EventDao;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Event;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Sruthi
 */
@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = {"classpath:applicationContext.xml" }) 
public class EventBusinessImplTest {
    
    @Autowired
    private EventDao eventDao;
    private Event event;
    private EventBusinessImpl eventBusinessImpl;
    private Date date;
    private Date date1;

    public EventDao getEventDao() {
        return eventDao;
    }

    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }
    
    
    public EventBusinessImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws ParseException {
        eventBusinessImpl = new EventBusinessImpl();
        eventBusinessImpl.setEventDao(eventDao);
        event=new Event();
        event.setEventName("pTestEventName");
        event.setEventDescription("pEvent Testing");
        event.setEventVenue("pTestingSuntec");
        String date_s = "24-04-2015";
        SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
        date = dt.parse(date_s);
        event.setEventStartDate(date);
        String date_e= "27-04-2015";
        date1= dt.parse(date_e);
        event.setEventEndDate(date1);
        event.setFile(null); 
        event.setEventPhoto("");
        //event.setIsWebCrawled(0);
        //event.setStatus(1);
       
  
    }
    
    @After
    public void tearDown() throws CmmaAppException {
        eventBusinessImpl.deleteEventBusiness(event);
       event=null;
       eventBusinessImpl=null;
    
    }

    /**
     * Test of setEventDao method, of class EventBusinessImpl.
     */
    //@Test
    public void testSetEventDao() {
       System.out.println("setEventDao");
        assertTrue(eventDao!=null);
    }

    /**
     * Test of getAllEvents method, of class EventBusinessImpl.
     */
    //@Test
    public void testGetAllEvents() throws Exception {
               
        List<Event> result = eventBusinessImpl.getAllEvents();
        assertTrue(!result.isEmpty());
    }

    /**
     * Test of loadEvents method, of class EventBusinessImpl.
     */
    //@Test
    public void testLoadEvents() throws Exception {
               Assert.assertEquals(true, eventBusinessImpl.loadEvents()); 
      
    }

    /**
     * Test of createEventBusniess method, of class EventBusinessImpl.
     */
    
    @Test
    public void testCreateEventBusniess() throws Exception {
       Assert.assertEquals("success", eventBusinessImpl.createEventBusniess(event));
    }

    /**
     * Test of modifyEventBusiness method, of class EventBusinessImpl.
     */
    @Test
    public void testModifyEventBusiness() throws Exception {
        event.setEventName("pTestEventNameChange");
     Assert.assertEquals(true, eventBusinessImpl.modifyEventBusiness(event));   
    event.setEventName("pTestEvent");
    }

    /**
     * Test of allEvents method, of class EventBusinessImpl.
     */

    @Test
    public void testAllEvents() throws Exception {
        String shopkeeperName= "Preeti";     
       List<Event> expResult = null;
       expResult= eventBusinessImpl.allEvents(shopkeeperName);
       for(Event evt:expResult){
           System.out.println(evt);
       }
        assertTrue(expResult!=null);
   
    }

   @Test
    public void testValidateEvent() throws Exception {
       Assert.assertEquals(true, eventBusinessImpl.validateEvent(event));
    }

    /**
     * Test of isValidateDateRange method, of class EventBusinessImpl.
     */
    @Test
    public void testIsValidateDateRange() {
        Assert.assertEquals(true, eventBusinessImpl.isValidateDateRange(date, date1));
    }

    /**
     * Test of deleteEventBusiness method, of class EventBusinessImpl.
     */
    @Test
    public void testDeleteEventBusiness() throws Exception {
        Assert.assertEquals(true, eventBusinessImpl.deleteEventBusiness(event));
    }
    
}
