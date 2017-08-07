/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.business.impl;

import com.ihpc.cmma.business.EventBusiness;
import com.ihpc.cmma.dao.EventDao;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Event;
import com.ihpc.cmma.util.FileUtils;
import static com.ihpc.cmma.util.FileUtils.encodeImage;
import com.ihpc.cmma.util.PropertyUtil;
import com.ihpc.cmma.util.WebCrawler;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.persistence.tools.file.FileUtil;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Sruthi
 */
public class EventBusinessImpl implements EventBusiness {

    private EventDao eventDao;

    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    @Override
    public List<Event> getAllEvents()  throws CmmaAppException{
        List<Event> events = eventDao.getAllEvents();
        for (Event event : events) {
            try{
                if (event.getEventPhoto() != null && !event.getEventPhoto().equals("")) {
                    String filePath = PropertyUtil.getPropery("event_images");
                    filePath = filePath + event.getEventPhoto();
                    event.setEventPhotoByte(encodeImage(FileUtils.LoadImage(filePath)));

                } else {
                    event.setEventPhotoByte("");
                }
            }
            catch(IOException e)
        {
         throw new CmmaAppException(e.getMessage());
        }
             
        }
        return events;
       
    }

    @Override
    public boolean loadEvents() throws Exception {
        boolean returnValue = false;
        WebCrawler crawler = new WebCrawler();
        Calendar cal = Calendar.getInstance();
        List<Event> allEvents = new ArrayList<>();
        try{
        for (int i = 1; i <= 12; i++) {
            List<Event> events = null;
            
                events = crawler.eventCrawler(i, cal.get(Calendar.YEAR));
            
            allEvents.addAll(events);
        }
        if (!allEvents.isEmpty()) {
            
                returnValue = eventDao.saveAllEvents(allEvents);
           
        }
        }
        catch(IOException e)
        {
         throw new CmmaAppException(e.getMessage());
        }
        return returnValue;
    }

    @Override
    public String createEventBusniess(Event event) throws CmmaAppException {
try{
        if (event.getFile() != null && !event.getFile().getFileName().equals("")) {
            String filePath;
           
                filePath = PropertyUtil.getPropery("event_images");
                File createFile = new File(filePath + event.getFile().getFileName());
                createFile.createNewFile();
                InputStream inputStr = event.getFile().getInputstream();
                OutputStream outStr = new FileOutputStream(createFile);
                FileUtil.copy(inputStr, outStr);
                event.setEventPhoto(event.getFile().getFileName());
        }else{
            event.setEventPhoto(PropertyUtil.getPropery("image_notAvailable"));
        }
        
        event.setIsWebCrawled(0);
        if (eventDao.insertEvent(event) == true) {

            return "success";

        } else {
            return "false";
        }
        }
       catch(IOException e)
        {
         throw new CmmaAppException(e.getMessage());
        }

    }

    @Override
    public boolean modifyEventBusiness(Event event) throws CmmaAppException {

        if (event.getFile() != null && !event.getFile().getFileName().equals("")) {
            String filePath;
            try {
                filePath = PropertyUtil.getPropery("event_images");
                File createFile = new File(filePath + event.getFile().getFileName());
                createFile.createNewFile();
                InputStream inputStr = event.getFile().getInputstream();
                OutputStream outStr = new FileOutputStream(createFile);
                FileUtil.copy(inputStr, outStr);
                event.setEventPhoto(event.getFile().getFileName());
            } catch (IOException ex) {
                Logger.getLogger(EventBusinessImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        event.setIsWebCrawled(0);
        return eventDao.modifyEvent(event);
    }

    @Override
    public List<Event> allEvents(String shopkeeperName)  throws CmmaAppException{
        List<Event> events = eventDao.allEvents(shopkeeperName);
        return events;
        
    }

    @Override
    public String getImagePathBusiness(Event event) {
        String filePath = null;
        try {
            filePath = PropertyUtil.getPropery("event_images");
            filePath = filePath + event.getEventPhoto();

        } catch (IOException ex) {
            Logger.getLogger(EventBusinessImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("FILEPATH" + filePath);
        return filePath;
    }

    @Override
    public boolean validateEvent(Event event) throws CmmaAppException {

        return eventDao.validateEvent(event);
    }

    @Override
    public boolean isValidateDateRange(Date startDate, Date endDate) {
        Date nd = new Date();

        if (startDate == null || endDate == null) {
            return false;
        }
        if (endDate.equals(startDate) || endDate.after(startDate)) {
            return true;
        }
        return false;
    }
    private String getImagePath(Event e) throws IOException{
        return PropertyUtil.getPropery("event_images") + e.getEventPhoto();
    }
    private StreamedContent getUploadedFileAsStream(Event event) {
        try {
            String filePath;
            if (event.getEventPhoto() != null && !event.getEventPhoto().equals("")) {
                filePath = PropertyUtil.getPropery("event_images") + event.getEventPhoto();
                return new DefaultStreamedContent(new ByteArrayInputStream(FileUtils.LoadImage(filePath)));
            } else {
                return null;
            }

        } catch (IOException ex) {
            Logger.getLogger(EventBusinessImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean deleteEventBusiness(Event event) throws CmmaAppException {

        return eventDao.deleteEvent(event);

    }
}
