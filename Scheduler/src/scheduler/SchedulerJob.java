/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduler;

/**
 *
 * @author ranveer
 */
import com.mysql.jdbc.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import java.sql.*;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

// This is implementation of diffdate 

public class SchedulerJob implements Job {

  

    @Override
    public void execute(JobExecutionContext  arg0 ) throws JobExecutionException  {
       Statement statement = null;
    ResultSet result = null;
    ResultSet res = null;
    ArrayList<String> loginarray = new ArrayList<String>();
    ArrayList<String> emailarray = new ArrayList<String>();
        
        String query = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SchedulerJob.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/olms", "root", "asd");
        } catch (SQLException ex) {
            Logger.getLogger(SchedulerJob.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            statement = (Statement) connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(SchedulerJob.class.getName()).log(Level.SEVERE, null, ex);
        }
         Statement statement1 = null;
        try {
            statement1 = (Statement) connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(SchedulerJob.class.getName()).log(Level.SEVERE, null, ex);
        }

        query = "select LoginID from issuedeposit id where id.DueDate < CURDATE()";
        try {
            result = statement.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(SchedulerJob.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(result.next())
            {
                String loginid = result.getString(1);
                loginarray.add(loginid);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SchedulerJob.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i=0;i<loginarray.size();i++)
        {
            try {
                res = statement1.executeQuery("select EmailID FROM studentaccount sa where sa.LoginID = '"+ loginarray.get(i) +"' ");
            } catch (SQLException ex) {
                Logger.getLogger(SchedulerJob.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                while(res.next())
                {
                 String email = res.getString(1);
                 emailarray.add(email);       
                }
            } catch (SQLException ex) {
                Logger.getLogger(SchedulerJob.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
       
    String[] email_array = new String[emailarray.size()];
    
    email_array = emailarray.toArray(email_array);
    
    AutoEmail autoemail = new AutoEmail();
        try {
            autoemail.sendemail(email_array);
        } catch (AddressException ex) {
            Logger.getLogger(SchedulerJob.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(SchedulerJob.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
        
        





    }
}
