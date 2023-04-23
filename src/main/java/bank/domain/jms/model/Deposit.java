package bank.domain.jms.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class Deposit implements Serializable {
    private long id;
    private BigDecimal amount;
    private Integer maturity;
    private String email;

    public static Deposit of(long id, BigDecimal amount, Integer maturity, String email) {
        return Deposit.builder()
            .id(id)
            .amount(amount)
            .maturity(maturity)
            .email(email)
            .build();
    }
}
