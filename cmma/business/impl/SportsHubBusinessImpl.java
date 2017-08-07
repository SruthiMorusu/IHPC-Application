/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.business.impl;

import com.ihpc.cmma.business.SportsHubBusiness;
import com.ihpc.cmma.crowd.javaCvCounter.HeadCounter;
import com.ihpc.cmma.dao.SportsHubDao;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.SportsHubGate;
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
public class SportsHubBusinessImpl implements SportsHubBusiness {

    private SportsHubDao hubDao;

    public void setHubDao(SportsHubDao hubDao) {
        this.hubDao = hubDao;
    }

    @Override
    public List<SportsHubGate> getAllGatesBusiness() throws CmmaAppException {
        List<SportsHubGate> gates = hubDao.getAllGates();
        for (SportsHubGate gate : gates) {
            if (gate.getCrowdCount() != null) {
                if (gate.getCrowdCount() >=1000) {
                    gate.setColor("red");
                } else if (gate.getCrowdCount() > 500 && gate.getCrowdCount() < 1000) {
                    gate.setColor("yellow");
                } else if (gate.getCrowdCount() <= 500) {
                    gate.setColor("green");
                }
            }else{
                gate.setColor("white");
            }

        }
        return gates;
    }

    @Override
    public Integer updateCrowdBusiness() throws CmmaAppException {
        HeadCounter headCounter = new HeadCounter();

        try {
            List<SportsHubGate> shGates = hubDao.getAllGates();
            for (SportsHubGate shGate : shGates) {
                String gateCode = shGate.getGateName();
                String filename = FileUtils.getImageFilename(gateCode, "sports_images");

                if (null != filename) {

                    int count = headCounter.detectPeople(filename);
                    shGate.setCrowdCount(count);
                    shGate.setLastrun(new Date());
                    hubDao.updateSportshubCrowdCount(shGate);

                } else {
                    shGate.setCrowdCount(CmmaConstants.NUMBER_ZERO);
                    shGate.setLastrun(new Date());
                    hubDao.updateSportshubCrowdCount(shGate);
                }

            }
        } catch (CmmaAppException ex) {
            Logger.getLogger(TaxiBusinessImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
