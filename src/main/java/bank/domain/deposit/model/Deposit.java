package bank.domain.deposit.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Deposit {
    private long id;

    public static Deposit from(long id) {
        return Deposit.builder()
                .id(id)
                .build();
    }
}
