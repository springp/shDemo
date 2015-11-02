package com.iboss;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
//import org.apache.tomcat.jdbc.pool.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration {

	private static final Logger LOGGER = Logger.getLogger(DatabaseConfiguration.class);
	
	@Value("${jdbc.driver}")
	private String driverClassName;

	@Value("${jdbc.url}")
	private String url;

	@Value("${jdbc.username}")
	private String username;

	@Value("${jdbc.password}")
	private String password;

	@Value("${hibernate.dialect}")
	private String dialect;

	@Value("${hibernate.hbm2ddl.auto}")
	private String auto;

	@Value("${hibernate.show_sql}")
	private String showSql;

	@Value("${hibernate.cache.use_second_level_cache}")
	private String cache;

	@Value("${hibernate.format_sql}")
	private String fmtSql;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.iboss.entity" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean(destroyMethod="close")
	public DataSource getDataSource() {

		Properties properties = new Properties();		
		properties.put("driverClassName", driverClassName);
		properties.put("jdbcUrl", url);
		properties.put("username", username);
		properties.put("password", password);
		properties.put("connectionTestQuery", "SELECT 1");
		HikariConfig hikariConfig = new HikariConfig(properties);	
		HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
		return hikariDataSource;
		

	}

	private Properties hibernateProperties() {
		LOGGER.info("======================DATABASE CONFIGURATION=========================");
		LOGGER.info("DRIVER CLASS -->" + driverClassName);
		LOGGER.info("DB URL       -->" + url);
		LOGGER.info("HBM 2 DDL    -->" + auto);
		LOGGER.info("SECOND CACHE -->" + cache);
		LOGGER.info("=====================================================================");
		Properties properties = new Properties();
		
		properties.put("hibernate.dialect", dialect);
		properties.put("hibernate.hbm2ddl.auto", auto);
		properties.put("hibernate.show_sql", showSql);
		properties.put("hibernate.format_sql", fmtSql);
		properties.put("hibernate.generate_statistics", true);
		
		properties.put("hibernate.cache.use_second_level_cache", cache);
		properties.put("hibernate.cache.use_query_cache", true);
		properties.put("hibernate.cache.provider_class","net.sf.ehcache.hibernate.EhCacheProvider");
		properties.put("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
		//properties.put("net.sf.ehcache.configurationResourceName", "cache-config.xml");
		
		properties.put("hibernate.search.default.directory_provider", "org.hibernate.search.store.impl.FSDirectoryProvider");
		properties.put("hibernate.search.default.indexBase", "D:/hibernate-index/indexes");
		return properties;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
	}
	
	@Bean
    public SpringLiquibase springLiquibase() {
        SpringLiquibase springLiquibase = new SpringLiquibase();
        springLiquibase.setDataSource(getDataSource());
        springLiquibase.setChangeLog("classpath:schema.xml");
        return springLiquibase;
    }
}