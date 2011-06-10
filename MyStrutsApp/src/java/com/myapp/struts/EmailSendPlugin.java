/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

/**
 *
 * @author ranveer
 */
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

/**
*NewsLetter.java
* @author amontejo
*/
public class EmailSendPlugin implements PlugIn {

public static final String PLUGIN_NAME_KEY = MailScheduler.class.getName();

    @Override
public void init(ActionServlet servlet, ModuleConfig config)
throws ServletException {
try {
System.out.println("Initializing Mail PlugIn");
ServletContext context = null;
context = servlet.getServletContext();
MailScheduler objPlugin = new MailScheduler();
context.setAttribute(PLUGIN_NAME_KEY, objPlugin);
} catch (Exception ex) {
}
}

    @Override
    public void destroy() {
        
    }
}