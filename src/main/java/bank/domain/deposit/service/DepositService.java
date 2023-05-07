package bank.domain.deposit.service;

import bank.domain.deposit.model.Deposit;
import bank.domain.deposit.repository.DepositRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepositService {
    private final DepositRepository depositRepository;

    public void test() {
        List<Deposit> deposits = depositRepository.getDeposits(
                Deposit.of(1, 10000, 365, "abc@naver.com")
        );
        System.out.println("service test");
    }
}
