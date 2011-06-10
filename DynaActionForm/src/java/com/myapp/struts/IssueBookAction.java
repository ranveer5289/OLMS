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

        IssueBookForm formBean = (IssueBookForm) form;
        int ISBNNumber = formBean.getISBNNumber();
        String loginID = formBean.getloginID();
        String adminID = formBean.getadminID();
        String duedate = formBean.getduedate();
        String issuedate = formBean.getissuedate();

        int value = 0;



        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/olms", "root", "asd");
        Statement statement = con.createStatement();



        value = statement.executeUpdate("insert into issuedeposit values ('" + ISBNNumber + "','" + adminID + "','" + loginID + "','" + duedate + "','" + issuedate + "')");
        ResultSet result = statement.executeQuery("select ISBN from issuedeposit");

        con.close();



        // if ( value ==0 || loginID.equals("") || adminID.equals("") || duedate.equals("") || issuedate.equals("") || ISBNNumber == 0) {


        if (value < 1 || loginID == null || loginID.length() < 1 || adminID.length() < 1 || duedate.length() < 1 || issuedate.length() < 1) {

            formBean.setError();

            return mapping.findForward(FAILURE);
        } else {
            formBean.setMessage();
            return mapping.findForward(SUCCESS);
        }

    }
}