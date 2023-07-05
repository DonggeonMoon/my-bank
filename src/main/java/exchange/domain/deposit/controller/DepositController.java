package exchange.domain.deposit.controller;

import exchange.domain.deposit.dto.DepositDto;
import exchange.domain.deposit.service.DepositService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepositController {
    private final DepositService depositService;

    @GetMapping("/")
    public String test() {
        depositService.test();
        return "test";
    }

    @PostMapping("/deposit")
    @ResponseStatus(HttpStatus.CREATED)
    public void creatDeposit(DepositDto depositDto) {
        depositService.createDeposit(depositDto);
    }

    @GetMapping("/deposits")
    public List<DepositDto> getDeposits(DepositDto depositDto) {
        return depositService.getDeposits(depositDto);
    }

    @GetMapping("/deposits/{id}")
    public DepositDto getDeposit(@PathVariable Long id) {
        return depositService.getDeposit(id);
    }

    @PutMapping("/deposit")
    public void updateDeposit(DepositDto depositDto) {
        depositService.updateDeposit(depositDto);
    }

    @DeleteMapping("/deposit")
    public void deleteDeposit(DepositDto depositDto) {
        depositService.deleteDeposit(depositDto);
    }
}
