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
public class IssueBookForm extends org.apache.struts.action.ActionForm {
     private String adminID;
    private String issuedate;
    private String duedate;
    private String error;
    private String admin;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = "succesfully updated";
    }
    private int ISBNNumber;
    private String loginID;

    public String getloginID() {
        return loginID;
    }

    public void setloginID(String loginID) {
        this.loginID = loginID;
    }
   
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = "<span style='color:red'>Please provide valid entries for fields</span>";
    }

    public String getadminID() {
        return adminID;
    }

    public void setadminID(String adminID) {
        this.adminID = adminID;
    }

    public String getduedate() {
        return duedate;
    }

    public void setduedate(String duedate) {
        this.duedate = duedate;
    }

    public int getISBNNumber() {
        return ISBNNumber;
    }

    public void setISBNNumber(int ISBNNumber) {
        this.ISBNNumber = ISBNNumber;
    }

    public String getissuedate() {
        return issuedate;
    }

    public void setissuedate(String issuedate) {
        this.issuedate = issuedate;
    }

   
   
   
    public IssueBookForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getloginID() == null || getissuedate() == null || getduedate() == null || getloginID().length() < 1 || getduedate().length() < 1 || getissuedate().length() < 1 || getadminID().length() < 1 ) 
        {
            errors.add("ISBNNumber", new ActionMessage("error.ISBNNumber.required"));
            errors.add("loginID", new ActionMessage("error.loginID.required"));
            errors.add("adminID", new ActionMessage("error.adminID.required"));
            errors.add("issuedate", new ActionMessage("error.issuedate.required"));
            errors.add("duedate", new ActionMessage("error.duedate.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }

    void setError() {
       
         this.error =  "<span style='color:red'>Please provide valid entries for fields</span>";
    }
    void setMessage(){
        this.message = "successfully updated";
    }
}
