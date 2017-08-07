/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Sruthi
 */
public class PropertyUtil {

    private static Properties props;

    public static String getPropery(String key) throws IOException {
        String value;
        if (null == props) {
            props = new Properties();
        }

        try (InputStream resourceStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("cmma_config.properties")) {
            props.load(resourceStream);
            value = props.get(key).toString();
        } catch (IOException ie) {
            throw new IOException();
        }
        return value;
    }
}
