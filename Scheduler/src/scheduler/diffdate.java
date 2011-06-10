/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduler;

/**
 *
 * @author ranveer
 */


import java.util.ArrayList;
import java.sql.*;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class diffdate
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException, AddressException, MessagingException 
    {
         Statement statement = null;
    ResultSet result = null;
    ResultSet res = null;
    ArrayList<String> loginarray = new ArrayList<String>();
    ArrayList<String> emailarray = new ArrayList<String>();
    
    
    String query = null;
         Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/olms", "root", "asd");
       
        statement = (Statement) connection.createStatement();
         Statement statement1 = (Statement) connection.createStatement();

        query = "select LoginID from issuedeposit id where id.DueDate < CURDATE()";
        
        result = statement.executeQuery(query);
        
        while(result.next())
        {
            String loginid = result.getString(1);
            loginarray.add(loginid);
        }

        for(int i=0;i<loginarray.size();i++)
        {
                
           res = statement1.executeQuery("select EmailID FROM studentaccount sa where sa.LoginID = '"+ loginarray.get(i) +"' ");
            String email = res.getString(1);
            emailarray.add(email);       
           }
        }
        
       
    String[] email_array = new String[emailarray.size()];
    
    email_array = emailarray.toArray(email_array);
    
    AutoEmail autoemail = new AutoEmail();  // creating object of autoemail class
    
    autoemail.sendemail(email_array);
    
    
    
    }
            
}




