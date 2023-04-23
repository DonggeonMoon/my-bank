package bank.domain.jms.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import bank.domain.jms.model.Deposit;
import bank.domain.jms.service.JmsService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class JmsController {
    private final JmsService jmsService;
    @GetMapping("/")
    public String test() {
        Deposit newDeposit = Deposit.of(1, BigDecimal.valueOf(10000), 365, "abc@naver.com");
        jmsService.createDeposit(newDeposit);
        return "finished";
    }

}
