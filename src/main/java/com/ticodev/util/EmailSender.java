package com.ticodev.util;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
SMTP 사용
 */
public class EmailSender {

    private static final String id;
    private static final String pw;

    private static final Properties props = new Properties();
    private final MimeMessage mail;

    static {
        final String resource = "D:\\projects\\2020\\simplog\\src\\main\\resources\\email.properties";
        BufferedReader input;
        Map<String, String> properties = new HashMap<>();

        try {
            input = new BufferedReader(new FileReader(resource));
            String data;
            while((data = input.readLine()) != null) {
                String[] temp = data.split("=");
                properties.put(temp[0], temp[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        id = properties.get("id");
        pw = properties.get("pw");
    }

    public EmailSender() {
        props.put("mail.smtp.host", "smtp.naver.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true"); // 없어도 됨
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true"); // TODO: 배포시 false
        props.put("mail.smtp.user", id);
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        MyAuthenticator auth = new MyAuthenticator(id, pw);
        Session session = Session.getInstance(props, auth);
        mail = new MimeMessage(session);
        try {
            mail.setFrom(new InternetAddress(id));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /* 메일 전송 성공 여부 반환 */
    public boolean sendEmail(String email, String subject, String content) {
        try {
            mail.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            return setupMail(subject, content);
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean sendEmail(String[] emails, String subject, String content) {
        try {
            InternetAddress[] address = new InternetAddress[emails.length];
            for (int i = 0; i < emails.length; i++) {
                address[i] = new InternetAddress(emails[i]);
            }
            mail.setRecipients(Message.RecipientType.TO, address);
            return setupMail(subject, content);
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean setupMail(String subject, String content)
            throws MessagingException {

        mail.setSubject(subject);
        mail.setSentDate(new Date());
        mail.setText(content);

        MimeMultipart multipart = new MimeMultipart();
        MimeBodyPart body = new MimeBodyPart();
        body.setContent(content, "text/html; charset=UTF-8");
        multipart.addBodyPart(body);
        mail.setContent(multipart);

        Transport.send(mail);
        return true;

    }

    private static final class MyAuthenticator extends Authenticator {

        private final String id;
        private final String pw;

        public MyAuthenticator(String id, String pw) {
            this.id = id;
            this.pw = pw;
        }

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(id, pw);
        }
    }

}
