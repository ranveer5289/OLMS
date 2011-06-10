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

public class SendEmail {

    private String email;
    private String text;

    public void sendemail(String email, String text) throws AddressException, MessagingException {
        this.email = email;
        this.text = text;

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
        
            InternetAddress sendTo = null;
            sendTo = new InternetAddress(email);

        message.addRecipient(Message.RecipientType.TO, sendTo);


        message.setSubject("Lost Password");
        message.setText(text);

        Transport transport = session.getTransport("smtps");
        transport.connect(host, userid, Password);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();

    }
}
