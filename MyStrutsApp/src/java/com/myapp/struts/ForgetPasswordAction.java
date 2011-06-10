/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author ranveer
 */
public class ForgetPasswordAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";
    private String emailstring;

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
        ForgetPasswordForm formbean = (ForgetPasswordForm) form;
        String emailid = formbean.getEmailid();

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/olms", "root", "asd");
        Statement statement1 = (Statement) connection.createStatement();
        Statement statement2 = (Statement) connection.createStatement();


        String query1 = "select count(*) from studentaccount where EmailID = '" + emailid + "'";

        ResultSet result1 = statement1.executeQuery(query1);


        while (result1.next()) {
            int res = result1.getInt(1);
            
            if (res == 1) {
                String query2 = "select Password from studentaccount  where emailID = '" + emailid + "'";
                ResultSet result2 = statement2.executeQuery(query2);
                
                while (result2.next()) {
                    String password = result2.getString(1);
                    String text = ("you requested for your lost password your password is: " + password);
                    SendEmail sm = new SendEmail();
                    sm.sendemail(emailid, text);

                }
            } else {


                errors.add("emailID", new ActionMessage("error.emailID.required"));
            }

        }


        saveErrors(request, errors);
        connection.close();



        if (!errors.isEmpty()) {
            return mapping.findForward(FAILURE);
        } else {
            return mapping.findForward(SUCCESS);
        }
    }
}
