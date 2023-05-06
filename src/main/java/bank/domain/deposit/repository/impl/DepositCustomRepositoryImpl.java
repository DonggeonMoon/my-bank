package bank.domain.deposit.repository.impl;

import bank.domain.deposit.dto.DepositDto;
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
    JPAQueryFactory jpaQueryFactory;

    public void save(Deposit deposit) {
        jpaQueryFactory.insert(QDeposit.deposit);
    }

    public List<Deposit> getDeposits() {
        return jpaQueryFactory.selectFrom(deposit)
                .fetch();
    }

    public Deposit getDeposit(DepositDto depositDto) {
        return jpaQueryFactory.selectFrom(deposit)
                .where(deposit.id.eq(depositDto.getId())
                        .and(deposit.amount.eq(depositDto.getAmount()))
                        .and(deposit.tenure.eq(depositDto.getTenure()))
                        .and(deposit.email.eq(depositDto.getEmail()))
                )
                .fetchOne();
    }

    public void delete(DepositDto depositDto) {
        jpaQueryFactory.delete(deposit)
                .where(deposit.id.eq(depositDto.getId())
                        .and(deposit.amount.eq(depositDto.getAmount()))
                        .and(deposit.tenure.eq(depositDto.getTenure()))
                        .and(deposit.email.eq(depositDto.getEmail()))
                ).execute();
    }
}
