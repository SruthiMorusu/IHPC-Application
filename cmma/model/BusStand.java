/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.model;

import java.util.List;

/**
 *
 * @author Sruthi
 */
public class BusStand {
    private String stopCode;
    private String lattitude;
    private String longitude;
    private String stopName;
    private List<String> busServices;

    public String getStopCode() {
        return stopCode;
    }

    public void setStopCode(String stopCode) {
        this.stopCode = stopCode;
    }

    public String getLattitude() {
        return lattitude;
    }

    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

  

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public List<String> getBusServices() {
        return busServices;
    }

    public void setBusServices(List<String> busServices) {
        this.busServices = busServices;
    }
    
    
}
