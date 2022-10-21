package com.smirnov.Company;

import com.smirnov.Company.Connection.ConConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.sql.*;

@SpringBootApplication()
public class CompanyApplication implements CommandLineRunner {

	@Autowired
	private ConConfig conConfig;

	public static void main(String[] args) {
		//SpringApplication.run(CompanyApplication.class, args);
		SpringApplication app = new SpringApplication(CompanyApplication.class);
		app.run();
		//new Connector().getConnection();
	}

	public void run(String... args) throws Exception {
		String sqlSelectAllPersons = "SELECT * FROM employee";

		try (Connection conn = getPrimaryDatasourceProperties().initializeDataSourceBuilder().build().getConnection();
			 PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
			 ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				long id = rs.getLong("id");
				String name = rs.getString("firstname");
				String lastName = rs.getString("lastname");

				System.out.println(id + " " + name + " " + lastName);
			}


		} catch (SQLException e) {
			System.out.println("Connection attempt failed");
		}

	}

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSourceProperties getPrimaryDatasourceProperties() {
		return new DataSourceProperties();
	}
}
