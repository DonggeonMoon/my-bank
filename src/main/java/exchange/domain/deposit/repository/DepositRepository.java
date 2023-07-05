package exchange.domain.deposit.repository;

import exchange.domain.deposit.model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Long>, DepositCustomRepository {
}
