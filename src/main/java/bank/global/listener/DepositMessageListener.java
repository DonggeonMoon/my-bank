package bank.global.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import bank.domain.jms.model.Deposit;

public class DepositMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            ObjectMessage objectMessage = (ObjectMessage)message;
            System.out.println("계좌가 생성됐습니다." + objectMessage.getBody(Deposit.class).getAmount());
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
