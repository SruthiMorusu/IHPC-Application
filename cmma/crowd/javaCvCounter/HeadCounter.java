/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.crowd.javaCvCounter;

import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.util.PropertyUtil;
import java.io.IOException;
import static org.bytedeco.javacpp.helper.opencv_objdetect.cvHaarDetectObjects;
import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;
import static org.bytedeco.javacpp.opencv_highgui.*;
import static org.bytedeco.javacpp.opencv_objdetect.CV_HAAR_DO_CANNY_PRUNING;
import org.bytedeco.javacpp.opencv_objdetect.CvHaarClassifierCascade;

public class HeadCounter {

    public Integer detectPeople(String path) throws CmmaAppException {
        int total_Faces=0;
        try {
            String xml = PropertyUtil.getPropery("head_xml");
        IplImage src = cvLoadImage(path);
        CvHaarClassifierCascade cascade = new CvHaarClassifierCascade(cvLoad(xml));
        CvMemStorage storage = CvMemStorage.create();
        CvSeq sign = cvHaarDetectObjects(
                src,
                cascade,
                storage,
                1.05,
                1,
                CV_HAAR_DO_CANNY_PRUNING);

        cvClearMemStorage(storage);

        total_Faces = sign.total();
        
        }catch (IOException e) {
            throw new CmmaAppException("Head detect exception", e);
        } 
        catch (Exception e) {
            throw new CmmaAppException("Head detect exception", e);
        }
        
    return total_Faces;
    }
}
