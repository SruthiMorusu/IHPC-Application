/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.business.impl;

import com.ihpc.cmma.business.BusStandBusiness;
import com.ihpc.cmma.dao.BusStandDao;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.exception.CmmaMongoException;
import com.ihpc.cmma.model.BusStand;
import java.util.List;

/**
 *
 * @author Sruthi
 */
public class BusStandBusinessImpl implements BusStandBusiness{

    private BusStandDao standDao;

    public void setStandDao(BusStandDao standDao) {
        this.standDao = standDao;
    }
    
    
    @Override
    public List<BusStand> getAllBusBusiness() throws CmmaAppException{
        return standDao.getAllBusStops();
    }
    
}
