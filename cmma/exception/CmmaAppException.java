/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihpc.cmma.exception;

/**
 *
 * @author A0120035A
 */
public class CmmaAppException extends Exception {

    public CmmaAppException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public CmmaAppException(String message) {
        super(message);
    }

}
