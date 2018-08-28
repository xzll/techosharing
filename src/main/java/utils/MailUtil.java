package utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class MailUtil {
    private MailSender mailSender;  
    private SimpleMailMessage simpleMailMessage;  
    //TODO
    //Spring ����ע��  
    public void setMailSender(MailSender mailSender) {  
        this.mailSender = mailSender;  
    }  
      
    //Spring ����ע��  
    public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {  
        this.simpleMailMessage = simpleMailMessage;  
    }  
    /** 
     * ���� 
     * 
     * @param recipient �ռ��� 
     * @param subject ���� 
     * @param content ���� 
     */  
    public void send(String recipient,String subject,String content){  
        simpleMailMessage.setTo(recipient);  
        simpleMailMessage.setSubject(subject);  
        simpleMailMessage.setText(content);  
        mailSender.send(simpleMailMessage);  
    }  
}
