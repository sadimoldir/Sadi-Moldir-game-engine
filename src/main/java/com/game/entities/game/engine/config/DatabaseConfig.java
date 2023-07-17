package com.game.entities.game.engine.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Objects;

@Configuration
@PropertySource("classpath:database.properties")
public class DatabaseConfig {
    private final Environment environment;

    @Autowired
    public DatabaseConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DriverManagerDataSource dataSource() {
        String driverClassName = Objects.requireNonNull(environment.getProperty("driverClassName"));
        String url = Objects.requireNonNull(environment.getProperty("url"));
        String username = Objects.requireNonNull(environment.getProperty("usernameDB"));
        String password = Objects.requireNonNull(environment.getProperty("passwordDB"));

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(Objects.requireNonNull(url));
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }


}

