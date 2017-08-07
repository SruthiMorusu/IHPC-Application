/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.dao.factory;

import com.relayrides.pushy.apns.ApnsEnvironment;
import com.relayrides.pushy.apns.PushManager;
import com.relayrides.pushy.apns.PushManagerConfiguration;
import com.relayrides.pushy.apns.util.SSLContextUtil;
import com.relayrides.pushy.apns.util.SimpleApnsPushNotification;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sruthi
 */
public class PushManagerFactory {


    public static PushManager getPushManager() {
         PushManager<SimpleApnsPushNotification> pushManager = null;
            try {
                pushManager = new PushManager<>(
                        ApnsEnvironment.getSandboxEnvironment(),
                        SSLContextUtil.createDefaultSSLContext("C:\\Users\\Dimo\\Documents\\NetBeansProjects\\cmma_Ihpc\\src\\main\\resources\\apns-dev-cert.p12", "crowdapp"),
                        null, // Optional: custom event loop group
                        null, // Optional: custom ExecutorService for calling listeners
                        null, // Optional: custom BlockingQueue implementation
                        new PushManagerConfiguration(),
                        "ExamplePushManager");
            } catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | UnrecoverableKeyException | KeyManagementException | IOException ex) {
                Logger.getLogger(PushManagerFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return pushManager;
    }

}
