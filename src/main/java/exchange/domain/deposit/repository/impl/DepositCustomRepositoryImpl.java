package exchange.domain.deposit.repository.impl;

import exchange.domain.deposit.dto.DepositDto;
import exchange.domain.deposit.model.Deposit;
import exchange.domain.deposit.repository.DepositCustomRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static exchange.domain.deposit.model.QDeposit.deposit;

@Repository
@RequiredArgsConstructor
public class DepositCustomRepositoryImpl implements DepositCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    @Transactional(readOnly = true)
    public List<Deposit> getDeposits(DepositDto depositDto) {
        return jpaQueryFactory.selectFrom(deposit)
                .where(deposit.id.eq(depositDto.getId())
                        .and(deposit.amount.eq(depositDto.getAmount()))
                        .and(deposit.tenure.eq(depositDto.getTenure()))
                        .and(deposit.email.eq(depositDto.getEmail())))
                .fetch();
    }

    @Override
    public Deposit getDeposit(DepositDto depositDto) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Deposit getDepositById(Long id) {
        return jpaQueryFactory.selectFrom(deposit)
                .where(deposit.id.eq(id))
                .limit(1)
                .fetchOne();
    }

    @Transactional
    public void update(DepositDto depositDto) {
        Deposit resultDeposit = getDepositById(depositDto.getId());
        resultDeposit.update(depositDto);

    }
}
