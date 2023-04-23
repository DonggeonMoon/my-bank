package bank.domain.jms.service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bank.domain.jms.model.Deposit;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JmsService {
    private final JmsTemplate jmsTemplate;
    private final RedisTemplate redisTemplate;


    @Transactional("jmsTransactionManager")
    public void createDeposit(Deposit deposit) {

        jmsTemplate.send("emailQueueDestination", session -> {
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText(deposit.getEmail());
            return textMessage;
        });

        jmsTemplate.send("bankQueue", session -> {
            ObjectMessage objectMessage = session.createObjectMessage();
            objectMessage.setObject(deposit);
            return objectMessage;
        });
    }
}
