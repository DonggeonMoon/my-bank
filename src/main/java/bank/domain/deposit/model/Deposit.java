package bank.domain.deposit.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Deposit {
    @Id
    @GeneratedValue()
    private long id;
    private BigDecimal amount;
    private int tenure;
    private String email;
}
