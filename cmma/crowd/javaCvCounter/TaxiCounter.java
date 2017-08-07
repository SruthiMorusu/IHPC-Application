/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.crowd.javaCvCounter;

/**
 *
 * @author A0120035A
 */
import com.ihpc.cmma.exception.CmmaAppException;
import org.bytedeco.javacpp.FloatPointer;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;
import static org.bytedeco.javacpp.opencv_highgui.*;

import org.bytedeco.javacpp.opencv_objdetect.HOGDescriptor;

public class TaxiCounter {

    public Integer countPeople(String path) throws CmmaAppException {
        if (null == path) {
            throw new CmmaAppException("path cannot be null");
        }

        IplImage img = cvLoadImage(path);
        HOGDescriptor hog = new HOGDescriptor();
        FloatPointer fpp = HOGDescriptor.getDefaultPeopleDetector();
        hog.svmDetector(fpp);
        Mat mat = cvarrToMat(img);
        Rect rect = new Rect();
        hog.detectMultiScale(mat, rect);
        return rect.capacity();

    }

}
