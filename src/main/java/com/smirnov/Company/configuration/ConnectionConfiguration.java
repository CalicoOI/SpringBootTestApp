package com.smirnov.Company.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class ConnectionConfiguration {

    @Autowired
    public ConnectionProperties connectionProperties;

    public ConnectionConfiguration() {}

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSourceProperties getPrimaryDatasourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "NamedParameterJdbcTemplate")
    @Primary
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(
                getPrimaryDatasourceProperties()
                        .initializeDataSourceBuilder().build());
    }
}

