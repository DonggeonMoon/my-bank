package bank.domain.deposit.repository.impl;

import bank.domain.deposit.model.Deposit;
import bank.domain.deposit.model.QDeposit;
import bank.domain.deposit.repository.DepositCustomRepository;
import com.querydsl.core.types.EntityPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static bank.domain.deposit.model.QDeposit.deposit;

@Repository
@RequiredArgsConstructor
public class DepositCustomRepositoryImpl implements DepositCustomRepository {
    private final EntityManager entityManager;
    private final JPAQueryFactory jpaQueryFactory;

    @Transactional(readOnly = true)
    public List<Deposit> getDeposits(Deposit depositDto) {
        return jpaQueryFactory.selectFrom(deposit)
                .where(deposit.id.eq(depositDto.getId())
                        .and(deposit.amount.eq(depositDto.getAmount()))
                        .and(deposit.tenure.eq(depositDto.getTenure()))
                        .and(deposit.email.eq(depositDto.getEmail())))
                .fetch();
    }

    @Transactional(readOnly = true)
    public Deposit getDepositById(Deposit depositDto) {
        return jpaQueryFactory.selectFrom(deposit)
                .where(deposit.id.eq(depositDto.getId()))
                .limit(1)
                .fetchOne();
    }

    @Transactional
    public void save(Deposit deposit) {
        entityManager.persist(deposit);
        entityManager.flush();
    }

    @Transactional
    public void update(Deposit deposit) {
        Deposit resultDeposit = getDepositById(deposit);
        resultDeposit.update(deposit);

    }

    @Transactional
    public void delete(Deposit deposit) {
        entityManager.remove(deposit);
    }
}
