/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

/**
 *
 * @author ranveer
 */
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class AutoEmail {

    private String[] emailarray;

    public void sendemail(String[] emailarray) throws AddressException, MessagingException {
        this.emailarray = emailarray;

        Session session = null;
        String host = "smtp.gmail.com";
        String userid = "ranveer.raghu@gmail.com";
        String Password = "goldcook83";
        String from = "ranveer.raghu@gmail.com";




        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.setProperty("mail.transport.protocol", "smtps");
        props.put("mail.smtp.user", userid);
        props.put("mail.smtp.password", Password);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtps.auth", "true");
        session = Session.getDefaultInstance(props, null);
        MimeMessage message = new MimeMessage(session);

        InternetAddress fromAddress = null;
        fromAddress = new InternetAddress(from);
        message.setFrom(fromAddress);

        InternetAddress[] sendTo = new InternetAddress[emailarray.length];

        for (int i = 0; i < emailarray.length; i++) {
            sendTo[i] = new InternetAddress(emailarray[i]);
        }

        message.setRecipients(Message.RecipientType.TO, sendTo);


        message.setSubject("hello");
        message.setText("This ia a test email.... if u get this plz email me so that i know u got it");

        Transport transport = session.getTransport("smtps");
        transport.connect(host, userid, Password);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();

    }
}
