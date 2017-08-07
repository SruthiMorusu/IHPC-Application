/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ihpc.cmma.dao;

import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Camera;
import com.ihpc.cmma.model.MallCrowd;
import java.util.List;

/**
 *
 * @author Sruthi
 */
public interface VenueDao {
    public MallCrowd getVenueCrowd(String mallName)throws CmmaAppException;
    public List<Camera> getCameras() throws CmmaAppException;
    public boolean updateVenueCrowdCount(Camera camera) throws CmmaAppException;
}
