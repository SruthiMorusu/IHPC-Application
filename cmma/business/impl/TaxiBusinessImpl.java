/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.business.impl;

import com.ihpc.cmma.business.TaxiBusiness;
import com.ihpc.cmma.crowd.javaCvCounter.TaxiCounter;
import com.ihpc.cmma.dao.TaxiDao;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Taxistand;
import com.ihpc.cmma.util.CmmaConstants;
import com.ihpc.cmma.util.FileUtils;
import com.ihpc.cmma.util.PropertyUtil;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sruthi
 */
public class TaxiBusinessImpl implements TaxiBusiness {

    private TaxiDao taxiDao;

    public void setTaxiDao(TaxiDao taxiDao) {
        this.taxiDao = taxiDao;
    }

    @Override
    public List<Taxistand> getTaxiStandBusiness() throws CmmaAppException {
        return taxiDao.getTaxistands();
    }

    @Override
    public Integer updateCrowdBusiness() throws CmmaAppException{

        TaxiCounter counter = new TaxiCounter();

            List<Taxistand> taxistands = taxiDao.getTaxistands();
            for (Taxistand taxi : taxistands) {
                String code = taxi.getTaxiStandCode();
                String filename = FileUtils.getImageFilename(code,"taxi_images");
                if (null != filename) {

                    int count = counter.countPeople(filename);
                    taxi.setPeopleQueueCount(count);
                    taxi.setLastrun(new Date());
                    int waitingTime;
                    try {
                        waitingTime = count * Integer.parseInt(PropertyUtil.getPropery("avg_taxi_arraival"));
                    } catch (IOException ex) {
                        throw new CmmaAppException("File Exception", ex);
                    }
                    taxi.setExpectedWaitTime(waitingTime + " mins");
                    taxiDao.updateCrowdCount(taxi);

                } else {
                    taxi.setPeopleQueueCount(CmmaConstants.NUMBER_ZERO);
                    taxi.setLastrun(new Date());
                    taxi.setExpectedWaitTime(" mins");
                    taxiDao.updateCrowdCount(taxi);
                }

            }
       
        return null;

    }

}
