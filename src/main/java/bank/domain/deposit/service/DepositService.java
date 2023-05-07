package bank.domain.deposit.service;

import bank.domain.deposit.dto.DepositDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.SQLException;

@Service
public class DepositService {
    public boolean save(DepositDto depositDto) {
        return true;
    }

    @Transactional
    public boolean createDeposit(DepositDto depositDto) throws SQLException {
        Connection connection = null;
        try {
            connection.setAutoCommit(false);

            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                connection.rollback();
                return false;
            }
        }
        return true;
    }
}
