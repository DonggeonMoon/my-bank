package bank.global.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class EmailMessageListener implements MessageListener {
    private final transient MailSender mailSender;
    private final transient SimpleMailMessage simpleMailMessage;

    public EmailMessageListener(MailSender mailSender, @Qualifier("requestReceivedTemplate") SimpleMailMessage simpleMailMessage) {
        this.mailSender = mailSender;
        this.simpleMailMessage = simpleMailMessage;
    }

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("이메일을 발송하였습니다." + message.getBody(String.class));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void sendEmail() {
        mailSender.send(simpleMailMessage);
    }
}
