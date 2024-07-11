package todolist_grupo3.todolist_grupo3.services.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;

public interface EmailService {
    JavaMailSender getJavaMailSender();


   /* @Async
    @Bean
     void sendVerificationEmail(String name, String toEmail, String token);*/
}
