/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.dao;

import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.SportsHubGate;
import java.util.List;

/**
 *
 * @author Sruthi
 */
public interface SportsHubDao {
    
    public List<SportsHubGate> getAllGates() throws CmmaAppException ;

    public boolean updateSportshubCrowdCount(SportsHubGate shGate) throws CmmaAppException;
    
}
