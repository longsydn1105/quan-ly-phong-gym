package model.bean;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailService {
	public void sendEmail(String toEmail, String otp) throws Exception {
        String host = "smtp.gmail.com";
        String fromEmail = "longsydn1105@gmail.com"; 
        String password = "fcjc wrli dmod mmrq"; 

        // Cấu hình kết nối SMTP
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        javax.mail.Session session = javax.mail.Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        // Soạn thảo email
        String subject = "Mã xác nhận 2FA";
        String body = "Mã xác nhận của bạn là: " + otp;

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(fromEmail));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        message.setSubject(subject);
        message.setText(body);

        try {
            System.out.println("Đang gửi email...");
            Transport.send(message);
            System.out.println("Email đã được gửi thành công.");
        } catch (MessagingException e) {
            System.out.println("Có lỗi khi gửi email: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
