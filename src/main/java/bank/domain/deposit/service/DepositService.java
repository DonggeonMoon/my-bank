package bank.domain.deposit.service;

import bank.domain.deposit.model.Deposit;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.SQLException;

public class DepositService {
    public boolean save(Deposit deposit) {
        return true;
    }

    @Transactional
    public boolean createDeposit(Deposit deposit) throws SQLException {
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
