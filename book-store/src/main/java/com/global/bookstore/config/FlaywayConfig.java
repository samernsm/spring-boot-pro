package com.global.bookstore.config;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlaywayConfig {
	
	@Autowired
    public FlaywayConfig(DataSource dataSource) {
        Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().migrate();
    }


}
