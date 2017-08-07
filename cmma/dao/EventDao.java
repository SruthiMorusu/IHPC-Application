/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ihpc.cmma.dao;

import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Event;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Sruthi
 */
public interface EventDao {
    public List<Event> getAllEvents() throws CmmaAppException;;
    public List<Event> allEvents(String shopkeeperName) throws CmmaAppException;;
    public boolean saveAllEvents(List<Event> allEvents) throws CmmaAppException;
    public boolean insertEvent(Event event) throws CmmaAppException;
    public boolean modifyEvent(Event event) throws CmmaAppException;
    public boolean validateEvent(Event event)throws CmmaAppException;
    public boolean deleteEvent(Event event) throws CmmaAppException;
}
