package sample.util;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mail {
    public static void sendMail(String recepient) throws Exception{
        System.out.println("Preparing to send email...");
        Properties propreties = new Properties();


        propreties.put("mail.smtp.auth", true);
        propreties.put("mail.smtp.starttls.enable", "true");
        propreties.put("mail.smtp.host", "smtp.gmail.com");
        propreties.put("mail.smtp.port", "587");
        propreties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        String myAccountEmail = "said.aabilla@gmail.com";
        String password = "jp0N9KXcVb5Y";

        Session session = Session.getInstance(propreties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail,password);
            }
        });
        Message message= prepareMessage(session,myAccountEmail,recepient);

        //Transport.send(message);
        System.out.println("Message sent successfully");
    }

    public static Message prepareMessage(Session session, String myAccountEmail, String recepient) {

        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
            message.setSubject("TravelGo Billet");

            //3) create MimeBodyPart object and set your message text
            BodyPart messageBodyPart1 = new MimeBodyPart();
            messageBodyPart1.setText("Thank you dear client, We have recieved your payment, here is the ticket:");

            //4) create new MimeBodyPart object and set DataHandler object to this object
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();
            String filename = GeneratePDF.file;//change accordingly
            DataSource source = new FileDataSource(filename);
            messageBodyPart2.setDataHandler(new DataHandler(source));
            messageBodyPart2.setFileName(filename);

            //5) create Multipart object and add MimeBodyPart objects to this object
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart1);
            multipart.addBodyPart(messageBodyPart2);

            //6) set the multiplart object to the message object
            message.setContent(multipart );

            //7) send message
            Transport.send(message);
            System.out.println("message sent....");

        }catch (MessagingException ex) {ex.printStackTrace();}
        return null;
    }


}
