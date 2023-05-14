package bank.domain.deposit.model;

import bank.domain.deposit.dto.DepositDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private BigDecimal amount;
    private Integer tenure;
    private String email;

    public static Deposit of(long id, double amount, Integer tenure, String email) {
        return Deposit.builder()
                .id(id)
                .amount(BigDecimal.valueOf(amount))
                .tenure(tenure)
                .email(email)
                .build();
    }

    public void update(DepositDto depositDto) {
        this.id = depositDto.getId();
        this.amount = depositDto.getAmount();
        this.tenure = depositDto.getTenure();
        this.email = depositDto.getEmail();
    }

    public DepositDto toDto() {
        return DepositDto.builder()
                .id(id)
                .amount(amount)
                .tenure(tenure)
                .email(email)
                .build();
    }
}
