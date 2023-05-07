package bank.domain.deposit.controller;

import bank.domain.deposit.service.DepositService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DepositController {
    private final DepositService depositService;

    @GetMapping("/")
    public String test() {
        depositService.test();
        return "test";
    }

}
