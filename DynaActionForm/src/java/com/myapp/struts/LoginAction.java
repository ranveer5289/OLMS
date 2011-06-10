/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.DynaActionForm;

/**
 *
 * @author TheSpecialisT
 */
public class LoginAction extends org.apache.struts.action.Action {

    private final static String SUCCESS = "success";
    private final static String FAILURE = "failure";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // extract user data
        DynaActionForm userform = (DynaActionForm) form;
        String name = (String) userform.get("name");
        String email = (String) userform.get("email");
        //  String date  = formBean.getDate();

        /*    Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        
        date = (dateFormat.format(calendar.getTime()));
        formBean.setDate(date.toString());*/
        String rt = null;


        ActionMessages errors = new ActionMessages();
        if (name == null || name.length() < 3) {
            errors.add("name", new ActionMessage("error.name"));
        }
        if (email == null || email.length() < 2) {
            errors.add("email", new ActionMessage("error.email"));
        }
        saveErrors(request, errors);


        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/user", "root", "asd");
        Statement statatment = con.createStatement();
        // String insert = "select * from userinfo";
        String insert = "select email from userinfo where name =('" + name + "')";
        ResultSet result = statatment.executeQuery(insert);
        // System.out.println(name);
        while (result.next()) {
            //System.out.println(email);

            rt = (result.getString(1)).toString();
        }




        // perform validation
        /*if (((name == null) ||             // name parameter does not exist
        email == null  ||             // email parameter doems not exist
        name.equals("") ||            // name parameter is empty
        
        email.indexOf("") == -1)) {   // email lacks '@'*/
        if (!(errors.isEmpty()) || !(rt.equals(email))) {

            // formBean.setError();
            //return mapping.findForward(SUCCESS);
            return mapping.findForward(FAILURE);
        } else {
            return mapping.findForward(SUCCESS);
        }

    }
}
