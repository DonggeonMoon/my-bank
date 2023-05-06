package bank.domain.deposit.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class DepositDto {
    private long id;
    private BigDecimal amount;
    private int tenure;
    private String email;

    public static DepositDto from(long id) {
        return DepositDto.builder()
                .id(id)
                .build();
    }
}
