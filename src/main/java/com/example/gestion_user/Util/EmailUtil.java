package com.example.gestion_user.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@Component
public class EmailUtil {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendPasswordResetEmail(String email, String token) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("Reset Your Password");
        mimeMessageHelper.setText("<div><a href=\"http://localhost:8091/user/reset-password?token=" + token + "\" target=\"_blank\">Click here to reset your password</a></div>", true);

        javaMailSender.send(mimeMessage);
        LOGGER.info("Password reset email sent to {}");
    }

}
