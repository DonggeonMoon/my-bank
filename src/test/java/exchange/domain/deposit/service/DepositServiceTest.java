package exchange.domain.deposit.service;

import exchange.domain.deposit.model.Deposit;
import exchange.domain.deposit.repository.DepositRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/dispatcher-servlet.xml",
        "file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
@WebAppConfiguration
@Slf4j
class DepositServiceTest {
    private Deposit deposit;
    private Deposit deposit2;
    private Deposit deposit3;
    private Deposit savedDeposit;
    private Deposit savedDeposit2;
    private Deposit savedDeposit3;

    @Autowired
    DepositRepository depositRepository;

    @BeforeEach
    void setUp() {
        deposit = Deposit.of(1, 10000, 1, "abc1@example.com");
        deposit2 = Deposit.of(2, 20000, 2, "abc2@example.com");
        deposit3 = Deposit.of(3, 30000, 3, "abc3@example.com");
    }

    @Test
    void createDeposit() {
        savedDeposit = depositRepository.save(deposit);
        Deposit deposit = depositRepository.getDepositById(savedDeposit.getId());

        System.out.println("savedDeposit = " + savedDeposit);
        System.out.println("deposit = " + deposit);

        assertThat(savedDeposit.getId()).isEqualTo(deposit.getId());
        assertThat(savedDeposit.getAmount().stripTrailingZeros()).isEqualTo(deposit.getAmount().stripTrailingZeros());
        assertThat(savedDeposit.getTenure()).isEqualTo(deposit.getTenure());
        assertThat(savedDeposit.getEmail()).isEqualTo(deposit.getEmail());

        savedDeposit2 = depositRepository.save(deposit2);
        Deposit deposit2 = depositRepository.getDepositById(savedDeposit2.getId());

        System.out.println("savedDeposit2 = " + savedDeposit2);
        System.out.println("deposit2 = " + deposit2);

        assertThat(savedDeposit2.getAmount().stripTrailingZeros()).isEqualTo(deposit2.getAmount().stripTrailingZeros());
        assertThat(savedDeposit2.getTenure()).isEqualTo(deposit2.getTenure());
        assertThat(savedDeposit2.getEmail()).isEqualTo(deposit2.getEmail());

        savedDeposit3 = depositRepository.save(deposit3);
        Deposit deposit3 = depositRepository.getDepositById(savedDeposit3.getId());

        System.out.println("savedDeposit3 = " + savedDeposit3);
        System.out.println("deposit3 = " + deposit3);

        assertThat(savedDeposit3.getAmount().stripTrailingZeros()).isEqualTo(deposit3.getAmount().stripTrailingZeros());
        assertThat(savedDeposit3.getTenure()).isEqualTo(deposit3.getTenure());
        assertThat(savedDeposit3.getEmail()).isEqualTo(deposit3.getEmail());
    }

    @AfterEach
    void tearDown() {
        depositRepository.deleteById(savedDeposit.getId());
        depositRepository.deleteById(savedDeposit2.getId());
        depositRepository.deleteById(savedDeposit3.getId());
    }
}