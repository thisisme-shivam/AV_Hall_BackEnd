package com.example.demo.service;

import java.util.Properties;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.*;

@Service
public class MailService {

    public void sendMailToUser(String email, String password) {
        // Set up the properties for your email server
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com"); // Replace with your SMTP server
        properties.put("mail.smtp.port", "587"); // Replace with the appropriate port
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Create a session with the email credentials
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("kumarshi605@gmail.com", "zxbr zwej ptuj zkvm"); // Replace with your email and password
            }
        });

        try {
            // Create a message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("kumarshi605@gmail.com")); // Replace with your email
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Your New Password");
            message.setText("Your new password is: " + password);

            // Send the message
            Transport.send(message);

            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            System.err.println("Failed to send email. Error: " + e.getMessage());
        }
    }

}
