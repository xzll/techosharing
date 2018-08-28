package utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class MailUtil {
    private MailSender mailSender;  
    private SimpleMailMessage simpleMailMessage;  
    //TODO
    //Spring 依赖注入  
    public void setMailSender(MailSender mailSender) {  
        this.mailSender = mailSender;  
    }  
      
    //Spring 依赖注入  
    public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {  
        this.simpleMailMessage = simpleMailMessage;  
    }  
    /** 
     * 单发 
     * 
     * @param recipient 收件人 
     * @param subject 主题 
     * @param content 内容 
     */  
    public void send(String recipient,String subject,String content){  
        simpleMailMessage.setTo(recipient);  
        simpleMailMessage.setSubject(subject);  
        simpleMailMessage.setText(content);  
        mailSender.send(simpleMailMessage);  
    }  
}
