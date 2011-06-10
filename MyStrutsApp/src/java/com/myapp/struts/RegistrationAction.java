/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;


/**
 *
 * @author ranveer
 */
public class RegistrationAction extends org.apache.struts.action.Action {

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
        RegistrationForm formBean = (RegistrationForm) form;
        int res = 0;
        
        String loginID = formBean.getloginID();
        String password = formBean.getPassword();
        String firstname = formBean.getFirstname();
        String lastname = formBean.getLastname();
        String emailID = formBean.getEmailID();
        String dob = formBean.getDob();
        int query_result;
        String query = null;
        
          Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/olms", "root", "asd");
         Statement statement = connection.createStatement();
         Statement statement1 = connection.createStatement();
         
         
         query = "select count(*) from studentaccount where LoginID = '"+loginID+"'";
         
         ResultSet result = statement1.executeQuery(query);
         while(result.next())
         {
              res = result.getInt(1);
         }
     
         if((res != 1))
         {
             query_result = statement.executeUpdate("insert into studentaccount values ('" + loginID + "','" + firstname + "','" + lastname + "','" + emailID + "','" + dob + "','" + password + "')");
         }
         
         else
         {
             errors.add("loginIDPresent", new ActionMessage("error.loginIDPresent"));
         }
             
         
         
        
        saveErrors(request,errors);
        
        
        
        if(!(errors.isEmpty()))
        {
            return mapping.findForward(FAILURE);
        }
        
        else        
        {
            formBean.setMessage();
            return mapping.findForward(SUCCESS);
        }
    }
}
