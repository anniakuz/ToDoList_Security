package todolist_grupo3.todolist_grupo3.services.auth;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import todolist_grupo3.todolist_grupo3.exception.HttpException;

import java.util.Properties;

import static todolist_grupo3.todolist_grupo3.utils.EmailUtils.getEmailMessage;

@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {
    /*@Autowired
    private JavaMailSender sender;

    @Value("${spring.mail.verify.host}") // for value coming from app.props -> ("smtp.gmail.com");

    private String host; //-> 587, stored in app.props
    @Value("${EMAIL_ID}") // for value coming from app.props, our email to send emails to users. To be created
    private String fromEmail;
    private static final String NEW_USER_ACCOUNT_VERIFICATION = "Account Verification for a new user";



    @Override
    @Bean
    @Async
    public void sendVerificationEmail(String name, String toEmail, String token) {
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject(NEW_USER_ACCOUNT_VERIFICATION);
            message.setFrom(fromEmail);
            message.setTo(toEmail);
            message.setText(getEmailMessage(name, host, token)); // method from EmailUtils
            sender.send(message);
        }catch(Exception e){
            throw new HttpException(HttpStatus.BAD_GATEWAY, "The message hasn't been sent");
        }
    }*/


    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("my.gmail@gmail.com"); // your email
        mailSender.setPassword("password");//your pasword

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
