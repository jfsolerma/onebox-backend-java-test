package com.onebox.cartmanagement.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.onebox.cartmanagement.config.persistence.PersistenceConfig;



@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CartRepositoryTest {
    @Test
    void testDeleteExpiredCart() {

    }
    @Configuration
    @Import(PersistenceConfig.class) // A @Component injected with ExampleService
    static class Config {
    }
}
