package bank.domain.deposit.repository;

import bank.domain.deposit.model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositRepository extends JpaRepository<Deposit, Long>, DepositCustomRepository {
}
