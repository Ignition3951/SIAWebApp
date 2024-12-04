package com.utk.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource(value = "classpath:application.properties")
public class ProjectConfig {

	@Value("${custom.datasource.url}")
	private String dataSourceUrl;

	@Value("${custom.datasource.username}")
	private String dataSourceUsername;

	@Value("${custom.datasource.password}")
	private String dataSourcePassword;

	@Bean
	public DataSource getDataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setJdbcUrl(dataSourceUrl);
		dataSource.setUsername(dataSourceUsername);
		dataSource.setPassword(dataSourcePassword);
		dataSource.setConnectionTimeout(1000);
		return dataSource;
	}
}
