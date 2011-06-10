/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import java.sql.*;


/**
 *
 * @author ranveer
 */
public class IssueBookAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ActionErrors errors = new ActionErrors();
        IssueBookForm formBean = (IssueBookForm) form;
        String ISBNNumber = formBean.getISBNNumber();
        String loginID = formBean.getloginID();
        String adminID = formBean.getadminID();
        String duedate = formBean.getduedate();
        String issuedate = formBean.getissuedate();
        int res1=0; int res2=0;int res3=0;
        
        int value = 0;
        String val = null;
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/olms", "root", "asd");
        Statement statement1 = con.createStatement();        
        Statement statement = con.createStatement();
        Statement statement2 = con.createStatement();
        val = "select count(*)  from issuedeposit where ISBN = '"+ISBNNumber+"'";
        ResultSet result_issue = statement.executeQuery(val);
        String val1 = "select count(*)from books where ISBN = '"+ISBNNumber+"'";
        ResultSet result_books = statement1.executeQuery(val1);
        String val2 = "select count(*) from  studentaccount where LoginID = '"+loginID+"'";
        ResultSet result_loginID = statement2.executeQuery(val2);
        
        
        while (result_books.next()) {
             res1 = result_books.getInt(1); 
          
        }
        
        while (result_loginID.next()) {
             res2 = result_loginID.getInt(1); 
           
        }
        
        while (result_issue.next()) {
             res3 = result_issue.getInt(1); 
            
        }
        
        
        if ((res1==1) & (!(res3==1)) & (res2==1))
        {
            value = statement.executeUpdate("insert into issuedeposit values ('" + ISBNNumber + "','" + adminID + "','" + loginID + "','" + duedate + "','" + issuedate + "')");
        }
        
        if (!(res1 == 1)) {
            errors.add("ISBN", new ActionMessage("error.required.ISBN"));
            
        }
        if (res3 == 1) {
            errors.add("ISBNPresent", new ActionMessage("error.ISBNPresent"));
        }
        if (!(res2 == 1)) {
            errors.add("loginidPresent", new ActionMessage("error.loginidPresent"));
        }
        
        saveErrors(request, errors);




        statement.close();
        statement1.close();
        statement2.close();
        con.close();



       

        
        if (!(errors.isEmpty())) {
           

            return mapping.findForward(FAILURE);
        } else {
            formBean.setMessage();
            return mapping.findForward(SUCCESS);
        }
        
    }
}
