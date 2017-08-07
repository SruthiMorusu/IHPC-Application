/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ihpc.cmma.business;

import com.ihpc.cmma.exception.CmmaException;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Event;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Sruthi
 */
public interface EventBusiness {

    public List<Event> getAllEvents()throws CmmaAppException;
    public boolean loadEvents() throws Exception;
    public List<Event> allEvents(String shopkeeperName) throws CmmaAppException;
    public String createEventBusniess(Event event) throws CmmaAppException;
    public boolean modifyEventBusiness(Event event) throws CmmaAppException;
    public String getImagePathBusiness(Event event)throws CmmaAppException;
    public boolean validateEvent(Event event) throws CmmaAppException;
    public boolean isValidateDateRange(Date startDate, Date endDate);
    public boolean deleteEventBusiness(Event event) throws CmmaAppException;
    
}
