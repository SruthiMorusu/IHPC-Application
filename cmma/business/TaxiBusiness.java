/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.business;

import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Taxistand;
import java.util.List;

/**
 *
 * @author A0120035A
 */
public interface TaxiBusiness {

    public List<Taxistand> getTaxiStandBusiness() throws CmmaAppException;

    public Integer updateCrowdBusiness() throws CmmaAppException;
}
