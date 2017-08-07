/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.util;

import com.ihpc.cmma.business.impl.VenueBusinessImpl;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sruthi
 */
public class FileUtils {

    public static byte[] LoadImage(String filePath) throws IOException {

        File file = new File(filePath);
        int size = (int) file.length();
        byte[] buffer = new byte[size];
        FileInputStream in = new FileInputStream(file);
        in.read(buffer);
        in.close();
        return buffer;
    }

    public static String encodeImage(byte[] imageByteArray) {
        return Base64.encode(imageByteArray);
    }

    public static byte[] LoadInputStream(InputStream stream) throws IOException {

        byte[] buffer = new byte[1024];
        stream.read(buffer);
        return buffer;
    }

    public static void saveFile(String imageUrl, String destinationFile) throws Exception {

        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(new File(destinationFile));

        byte[] b = new byte[2048];
        int length;

        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();

    }
    
    public static String getImageFilename(String code,String folderName) {
        String[] possibleExtensions = {"jpeg", "jpg", "png", "JPEG", "JPG", "PNG"};
        try {
            String filePath = PropertyUtil.getPropery(folderName);
            for (String ext : possibleExtensions) {
                String fullPath = filePath + code + "." + ext;
                File file = new File(fullPath);
                if (file.exists()) {
                    return fullPath;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(VenueBusinessImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
