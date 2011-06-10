/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author ranveer
 */
public class DepositForm extends org.apache.struts.action.ActionForm {
    private String error;
    private String message;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = "Enter correct value";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = "succesfully deleted";
    }

    public int getISBNNumber() {
        return ISBNNumber;
    }

    public void setISBNNumber(int ISBNNumber) {
        this.ISBNNumber = ISBNNumber;
    }
    
   private int ISBNNumber;
   
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getISBNNumber()==0) {
            errors.add("ISBNNumber", new ActionMessage("error.ISBNNumber.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }
        void setError(){
        this.error= "enter proper value";
    }

    void setMessage() {
       this.message= "Successfully deleted";
    }
}
