package bank.domain.deposit.repository;

import bank.domain.deposit.model.Deposit;

import java.util.List;

public interface DepositCustomRepository {
    List<Deposit> getDeposits(Deposit depositDto);
}
