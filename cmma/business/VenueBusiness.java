/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.business;

import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.MallCrowd;

/**
 *
 * @author Sruthi
 */
public interface VenueBusiness {
  
    public MallCrowd getVenueCrowd( String mallName) throws CmmaAppException;
    
    public Integer updateVenueCrowdBusiness() throws CmmaAppException;
}
