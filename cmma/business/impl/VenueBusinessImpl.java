/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.business.impl;

import com.ihpc.cmma.business.VenueBusiness;
import com.ihpc.cmma.crowd.javaCvCounter.HeadCounter;
import com.ihpc.cmma.dao.VenueDao;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Camera;
import com.ihpc.cmma.model.MallCrowd;
import com.ihpc.cmma.util.CmmaConstants;
import com.ihpc.cmma.util.FileUtils;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sruthi
 */
public class VenueBusinessImpl implements VenueBusiness {

    private VenueDao venueDao;

    public void setVenueDao(VenueDao venueDao) {
        this.venueDao = venueDao;
    }

    @Override
    //Method to retrieve the crowd information of all the venues in the mall
    
    public MallCrowd getVenueCrowd(String mallName) throws CmmaAppException {
        return venueDao.getVenueCrowd(mallName);
    }
   

    @Override
    //Method to update the crowd count retrived from the camera image of the mall venue.
    
    public Integer updateVenueCrowdBusiness() throws CmmaAppException {
        
        HeadCounter headCounter = new HeadCounter();
        
        try {
            List<Camera> cameras = venueDao.getCameras();
            for (Camera c : cameras) {
                String camCode = c.getCameraCode();
                String filename = FileUtils.getImageFilename(camCode,"venue_images");
                
                if (null != filename) {
                    int count = headCounter.detectPeople(filename);
                    c.setCrowd(count);
                    c.setLastrun(new Date());
                    c.setColor(this.getColor(count));
                    venueDao.updateVenueCrowdCount(c);
                    
                } else {
                    c.setCrowd(CmmaConstants.NUMBER_ZERO);
                    c.setLastrun(new Date());       
                    venueDao.updateVenueCrowdCount(c);
                }

            }
        } catch (CmmaAppException ex) {
            Logger.getLogger(TaxiBusinessImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private String getColor(int count) {
         if(count>1000){
                return "red";
            }else if(count>500 && count<1000){
                return "yellow";
            }else{
               return "green";
            }
    }
     
}
