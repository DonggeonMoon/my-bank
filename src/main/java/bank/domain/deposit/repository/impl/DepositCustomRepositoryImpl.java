package bank.domain.deposit.repository.impl;

import bank.domain.deposit.model.Deposit;
import bank.domain.deposit.model.QDeposit;
import bank.domain.deposit.repository.DepositCustomRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static bank.domain.deposit.model.QDeposit.deposit;

@Repository
@RequiredArgsConstructor
public class DepositCustomRepositoryImpl implements DepositCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public List<Deposit> getDeposits(Deposit depositDto) {
        return jpaQueryFactory.selectFrom(deposit)
                .where(deposit.id.eq(depositDto.getId())
                        .and(deposit.amount.eq(depositDto.getAmount()))
                        .and(deposit.tenure.eq(depositDto.getTenure()))
                        .and(deposit.email.eq(depositDto.getEmail())))
                .fetch();
    }
}
