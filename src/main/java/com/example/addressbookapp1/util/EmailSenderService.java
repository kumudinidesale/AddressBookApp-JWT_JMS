package com.example.addressbookapp1.util;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Component;


@Component
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailsender;
//   JavaMailSender sender =new JavaMailSender ();



    public void sendEmail(String toEmail, String subject, String body ) {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("kdesale1211@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        mailsender.send(message);
        System.out.println("Mail sent to the User...!");

    }
}
