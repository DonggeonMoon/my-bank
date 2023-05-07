package bank.domain.deposit.model;

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

    public void update(long id, double amount, Integer tenure, String email) {
        this.id = id;
        this.amount = BigDecimal.valueOf(amount);
        this.tenure = tenure;
        this.email = email;
    }

    public void update(Deposit deposit) {
        this.id = deposit.getId();
        this.amount = deposit.getAmount();
        this.tenure = deposit.getTenure();
        this.email = deposit.getEmail();
    }
}
