/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.business.impl;

import com.ihpc.cmma.business.PromotionBusiness;
import com.ihpc.cmma.dao.PromotionDao;
import com.ihpc.cmma.exception.CmmaException;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Promotion;
import com.ihpc.cmma.util.FileUtils;
import static com.ihpc.cmma.util.FileUtils.encodeImage;
import com.ihpc.cmma.util.PropertyUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.persistence.tools.file.FileUtil;

/**
 *
 * @author Sruthi
 */
public class PromotionBusinessImpl implements PromotionBusiness {

    private PromotionDao promotionDao;

    public void setPromotionDao(PromotionDao promotionDao) {
        this.promotionDao = promotionDao;
    }

    @Override
    public List<Promotion> getAllPromosBusiness() throws CmmaAppException, IOException {
        List<Promotion> promotions = promotionDao.getAllPromosDao();
        for (Promotion promotion : promotions) {

            if (promotion.getPromotionPhoto() != null && !promotion.getPromotionPhoto().equals("")) {
                String filePath = PropertyUtil.getPropery("promotion_images");
                filePath = filePath + promotion.getPromotionPhoto();
                promotion.setPromotionPhotoByte(encodeImage(FileUtils.LoadImage(filePath)));
            } else {
                promotion.setPromotionPhotoByte("");
            }

        }
        return promotions;
    }

    @Override
    public String createPromotionBusiness(Promotion promotion) throws CmmaAppException {
        try {
            if (promotion.getFile() != null && !promotion.getFile().getFileName().equals("")) {
                String filePath;

                filePath = PropertyUtil.getPropery("promotion_images");
                File createFile = new File(filePath + promotion.getFile().getFileName());
                createFile.createNewFile();
                InputStream inputStr = promotion.getFile().getInputstream();
                OutputStream outStr = new FileOutputStream(createFile);
                FileUtil.copy(inputStr, outStr);
                promotion.setPromotionPhoto(promotion.getFile().getFileName());
            }

            if (promotion.getFile() == null) {

                promotion.setPromotionPhoto(null);
            }

            if (promotionDao.insertPromotion(promotion) == true) {

                return "success";

            } else {
                return "failure";
            }
        } catch (IOException e1) {

            throw new CmmaAppException(e1.getMessage());

        }

    }

    @Override
    public boolean modifyPromotionBusiness(Promotion promotion) throws CmmaAppException {
        if(promotion.getFile()!=null && !promotion.getFile().getFileName().equals("")){
            try {
                String filePath = PropertyUtil.getPropery("promotion_images");
                File createFile = new File(filePath + promotion.getFile().getFileName());
                createFile.createNewFile();
                InputStream inputStr = promotion.getFile().getInputstream();
                OutputStream outStr = new FileOutputStream(createFile);
                FileUtil.copy(inputStr, outStr);
                promotion.setPromotionPhoto(promotion.getFile().getFileName());
            } catch (IOException ex) {
                Logger.getLogger(PromotionBusinessImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return promotionDao.modifyPromotion(promotion);

    }

    @Override
    public boolean deletePromotionBusiness(Promotion promotion) throws CmmaAppException {

        return promotionDao.deletePromotion(promotion);

    }

    @Override
    public List<Promotion> allPromotions(String shopkeeperName) throws CmmaAppException {
        List<Promotion> promotions = promotionDao.allPromotions(shopkeeperName);
        return promotions;
    }

    @Override
    public boolean promotionValidate(Promotion promotion) throws CmmaAppException {

        return promotionDao.promotionValidate(promotion);
    }

    @Override
    public boolean isValidateDateRange(Date startDate, Date endDate) throws CmmaException {

        if (startDate == null || endDate == null) {
            return false;
        }

        if (endDate.equals(startDate) || endDate.after(startDate)) {
            return true;
        }

        return false;
    }

}
