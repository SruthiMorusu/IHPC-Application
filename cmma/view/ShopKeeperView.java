/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.view;

import com.ihpc.cmma.business.ShopkeeperBusiness;
import com.ihpc.cmma.exception.CmmaAppException;
import com.ihpc.cmma.model.Shopkeeper;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.eclipse.persistence.internal.xr.Util;
import org.eclipse.persistence.sessions.Session;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 *
 * @author Sruthi
 */
@RequestScoped
@ManagedBean
public class ShopKeeperView extends SpringBeanAutowiringSupport {

    private Shopkeeper shopkeeper;
    private String newPassword;
    @Autowired
    private ShopkeeperBusiness shopkeeperBusiness;

    public void setShopkeeperBusiness(ShopkeeperBusiness shopkeeperBusiness) {
        this.shopkeeperBusiness = shopkeeperBusiness;
    }

    @PostConstruct
    public void init() {
        shopkeeper = new Shopkeeper();
    }

    public Shopkeeper getShopkeeper() {
        return shopkeeper;
    }

    public void setShopkeeper(Shopkeeper shopkeeper) {
        this.shopkeeper = shopkeeper;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String register() {
        String shopkeepername = this.shopkeeper.getShopkeeperName();

        String shopkeeperpassword = this.shopkeeper.getShopkeeperPassword();

        String shopkeeperEmailid = this.shopkeeper.getEmailid();
        String shopkName = this.shopkeeper.getCompanyName();
        String shopId = this.shopkeeper.getShopNumber();
        String shopkConfPassword = this.shopkeeper.getConfimPassword();
        String page1 = null;
        try {
            if (shopkeepername.equals("") || shopkeeperpassword.equals("") || shopkeeperEmailid.equals("") || shopkName.equals("") || shopId.equals("") || shopkConfPassword.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Please Enter Mandatory Fields"));
                return null;

            } else if (validateConfirmPswd() != true) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN,
                                "Invalid Details", "Password doesnt match"));
                return null;
            } else if (shopkeeperBusiness.registerValidate(shopkeeper) == false) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Name or the Email Id already Exists"));
                return null;
            } else if (shopkeeperBusiness.register(shopkeeper).equals("success")) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.getExternalContext().getFlash().setKeepMessages(true);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Registration Succesfull"));
                return "ShopkeeperLogin?faces-redirect=true";
            }
        } catch (CmmaAppException e) {

            e.getMessage();
            Logger.getLogger(ShopKeeperView.class.getName()).log(Level.SEVERE, null, e);
            return "error.xhtml";
        }
        return null;
    }

    public String logout() {

        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest req = (HttpServletRequest) fc.getExternalContext().getRequest();
        HttpSession session = req.getSession();
        session.setAttribute("username", null);
        session.invalidate();
        return "ShopkeeperLogin?faces-redirect=true";
    }

    public String validateShopkeeperLogin() {

        String shopkeeperName = this.shopkeeper.getShopkeeperName();
        String password = this.shopkeeper.getShopkeeperPassword();
        String page = null;
        try {
            if (shopkeeperName.equalsIgnoreCase("") || password.equalsIgnoreCase("")) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Action Required", "Please Enter Mandatory Fields"));
                page = null;
            } else {
                if (shopkeeperBusiness.validateShopkeeperLogin(shopkeeper) == true) {
                    FacesContext fc = FacesContext.getCurrentInstance();
                    HttpServletRequest req = (HttpServletRequest) fc.getExternalContext().getRequest();
                    HttpSession session = req.getSession();
                    session.setAttribute("username", shopkeeperName);

                    page = "HomePage?faces-redirect=true";
                } else {
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_WARN,
                                    "Passwords doesnt match!", "Please Try Again!"));
                    page = null;
                }
            }
        } catch (CmmaAppException e) {
            Logger.getLogger(ShopKeeperView.class.getName()).log(Level.SEVERE, null, e);
            return "error.xhtml";
        }

        return page;
    }

    public String updatePassword() throws CmmaAppException {
        String shopkeeperName = this.shopkeeper.getShopkeeperName();

        String emailId = this.shopkeeper.getEmailid();

        String password = this.shopkeeper.getShopkeeperPassword();
        String page = null;
        try {
            if ((shopkeeperName.equals("") || emailId.equals("") || password.equals("")
                    || newPassword.equals("")) || (shopkeeperName.equals("") || password.equals("") || newPassword.equals(""))) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Please Enter Mandatory Fields"));
                page = null;

            } else {
                System.out.println(shopkeeper.getShopkeeperPassword());
                if (shopkeeperBusiness.updateShopkeeperPassword(shopkeeper, newPassword) == true) {
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_WARN,
                                    "Password has been updated!", "Successfully!"));
                    page = "ShopkeeperLogin.xhtml";
                } else {
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_WARN,
                                    "Invalid Details!", "Please Correct!"));
                    page = null;
                }
            }
        } catch (CmmaAppException e) {

            e.getMessage();
            Logger.getLogger(ShopKeeperView.class.getName()).log(Level.SEVERE, null, e);
            return "error.xhtml";
        }
        return page;
    }

    public Boolean validateConfirmPswd() {
        if (!shopkeeper.getShopkeeperPassword().equals(shopkeeper.getConfimPassword())) {
            return false;
        } else {
            return true;
        }
    }

}
