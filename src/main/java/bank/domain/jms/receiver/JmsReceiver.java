package bank.domain.jms.receiver;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import bank.domain.jms.model.Deposit;

@Component
public class JmsReceiver {
    @JmsListener(id = "depositMessageListener", containerFactory = "jmsListenerContainerFactory", destination = "bankQueue")
    public void receiveDepositMessage(Message message) {
        try {
            ObjectMessage objectMessage = (ObjectMessage)message;
            System.out.println("계좌가 생성됐습니다." + objectMessage.getBody(Deposit.class).getAmount());
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    @JmsListener(id = "emailMessageListener", containerFactory = "jmsListenerContainerFactory", destination = "emailQueueDestination")
    public void receiveEmailMessage(Message message) {
        try {
            System.out.println("이메일을 발송하였습니다." + message.getBody(String.class));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
