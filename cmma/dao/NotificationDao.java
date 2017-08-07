/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.dao;

import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.MobileToken;
import java.util.List;

/**
 *
 * @author Sruthi
 */
public interface NotificationDao {
    public void registerMobile(MobileToken token) throws CmmaAppException;
    public List<MobileToken> getAllRegisteredMobiles() throws CmmaAppException;
}
