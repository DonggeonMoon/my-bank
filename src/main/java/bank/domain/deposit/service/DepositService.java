package bank.domain.deposit.service;

import bank.domain.deposit.dto.DepositDto;
import bank.domain.deposit.model.Deposit;
import bank.domain.deposit.repository.DepositRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepositService {
    private final DepositRepository depositRepository;

    public void test() {
        System.out.println("service test");
    }

    public void createDeposit(DepositDto depositDto) {
        depositRepository.save(depositDto.toEntity());
    }

    public List<DepositDto> getDeposits(DepositDto depositDto) {
        return depositRepository.getDeposits(depositDto)
                .stream()
                .map(Deposit::toDto)
                .collect(Collectors.toList());
    }

    public DepositDto getDeposit(Long id) {
        return depositRepository.getDepositById(id).toDto();
    }

    public void updateDeposit(DepositDto depositDto) {
        depositRepository.update(depositDto);
    }

    public void deleteDeposit(DepositDto depositDto) {
        depositRepository.delete(depositDto.toEntity());
    }
}
