package exchange.domain.deposit.repository;

import exchange.domain.deposit.dto.DepositDto;
import exchange.domain.deposit.model.Deposit;

import java.util.List;

public interface DepositCustomRepository {
    List<Deposit> getDeposits(DepositDto depositDto);
    Deposit getDeposit(DepositDto depositDto);
    Deposit getDepositById(Long id);
    void update(DepositDto depositDto);
}
