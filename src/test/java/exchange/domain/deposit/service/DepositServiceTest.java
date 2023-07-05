package exchange.domain.deposit.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/dispatcher-servlet.xml",
        "file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
@WebAppConfiguration
class DepositServiceTest {

    @Configuration
    static class TestConfig {
    }

    @Autowired
    DepositService depositService;

    @Test
    void test() {
        depositService.test();
        }
}