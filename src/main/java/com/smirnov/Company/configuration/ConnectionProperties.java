package com.smirnov.Company.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class ConnectionProperties {
    private String driverClassname;
    private String url;
    private String username;
    private String password;

    public ConnectionProperties() {
    }

    public ConnectionProperties(String driverClassname, String url, String username, String password) {
        this.driverClassname = driverClassname;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String getDriverClassname() {
        return driverClassname;
    }

    public void setDriverClassname(String driverClassname) {
        this.driverClassname = driverClassname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}