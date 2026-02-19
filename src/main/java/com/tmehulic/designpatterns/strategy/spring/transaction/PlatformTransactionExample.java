package com.tmehulic.designpatterns.strategy.spring.transaction;

import org.jspecify.annotations.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionTimedOutException;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class PlatformTransactionExample {

    @Bean
    @Primary
    public PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
        return new CustomTransactionManager(dataSource);
    }

    static class CustomTransactionManager extends JdbcTransactionManager {
        public CustomTransactionManager(DataSource dataSource) {
            super(dataSource);
        }

        @Override
        protected void doBegin(
                @NonNull Object transaction, @NonNull TransactionDefinition definition) {
            throw new TransactionTimedOutException("Custom exception");
        }
    }
}
