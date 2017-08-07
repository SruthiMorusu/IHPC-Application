/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.business.impl;

import com.ihpc.cmma.business.NotificationBusiness;
import com.ihpc.cmma.dao.NotificationDao;
import com.ihpc.cmma.dao.factory.PushManagerFactory;
import com.ihpc.cmma.exception.CmmaException;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Event;
import com.ihpc.cmma.model.MobileToken;
import com.ihpc.cmma.model.Promotion;
import com.relayrides.pushy.apns.ApnsEnvironment;
import com.relayrides.pushy.apns.PushManager;
import com.relayrides.pushy.apns.PushManagerConfiguration;
import com.relayrides.pushy.apns.util.ApnsPayloadBuilder;
import com.relayrides.pushy.apns.util.MalformedTokenStringException;
import com.relayrides.pushy.apns.util.SSLContextUtil;
import com.relayrides.pushy.apns.util.SimpleApnsPushNotification;
import com.relayrides.pushy.apns.util.TokenUtil;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sruthi
 */
public class NotificationBusinessImpl implements NotificationBusiness {

    private NotificationDao notificationDao;

    @Override
    public void registerMobileBusiness(MobileToken token) throws CmmaAppException {
        notificationDao.registerMobile(token);
    }

    @Override
    public boolean notifyPromotion(Promotion promotion) throws CmmaAppException {
        List<MobileToken> tokens = notificationDao.getAllRegisteredMobiles();
        return sendNotification(promotion.getPromotionName(), tokens);

    }

    @Override
    public boolean notifyEvent(Event event) throws CmmaAppException {
        List<MobileToken> tokens = notificationDao.getAllRegisteredMobiles();
        return sendNotification(event.getEventName(), tokens);
    }

    private boolean sendNotification(String message, List<MobileToken> tokens) throws CmmaAppException {
        try {
            PushManager manager = this.getPushManager();
            manager.start();

            final ApnsPayloadBuilder payloadBuilder = new ApnsPayloadBuilder();

            payloadBuilder.setAlertBody(message);
            payloadBuilder.setSoundFileName("ring-ring.aiff");
            final String payload = payloadBuilder.buildWithDefaultMaximumLength();
            for (MobileToken mobileToken : tokens) {
                final byte[] token = TokenUtil.tokenStringToByteArray(
                        mobileToken.getToken());
                manager.getQueue().put(new SimpleApnsPushNotification(token, payload));
            }

            manager.shutdown();
            Logger.getLogger(EventBusinessImpl.class.getName()).log(Level.INFO,"pushed Message to client");
            return true;
        } catch (InterruptedException | MalformedTokenStringException ex) {
            Logger.getLogger(EventBusinessImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new CmmaAppException("Push Notification Failure");
        }
    }

    public NotificationDao getNotificationDao() {
        return notificationDao;
    }

    public void setNotificationDao(NotificationDao notificationDao) {
        this.notificationDao = notificationDao;
    }
    
    private PushManager getPushManager(){
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
