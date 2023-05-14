package bank.domain.deposit.dto;

import bank.domain.deposit.model.Deposit;
import lombok.*;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class DepositDto {
    private long id;
    private BigDecimal amount;
    private Integer tenure;
    private String email;

    public Deposit toEntity() {
        return Deposit.builder()
                .id(id)
                .amount(amount)
                .tenure(tenure)
                .email(email)
                .build();
    }
}
