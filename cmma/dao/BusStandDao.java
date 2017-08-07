/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.dao;

import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.exception.CmmaMongoException;
import com.ihpc.cmma.model.BusStand;
import java.util.List;

/**
 *
 * @author A0120035A
 */
public interface BusStandDao {
    public List<BusStand> getAllBusStops()throws CmmaAppException;
}
