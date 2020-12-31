package org.zerock.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// root-config를 대신하는 기능(p44) : 방문자 공통 적용
@Controller
@Configuration
@ComponentScan(basePackages = "org.zerock.service")
@MapperScan(basePackages = {"org.zerock.mapper"}) // (96)
//(597) 자바 설정 - 트랜잭션 aop미적용
@EnableScheduling
@ComponentScan(basePackages = "org.zerock.task") // (599)

public class RootConfig {
	@Bean
	public DataSource dataSource() {
			HikariConfig hikariConfig = new HikariConfig();
//			hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//			hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
			hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
			hikariConfig.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@localhost:1522:orcl");
			hikariConfig.setUsername("spring");
			hikariConfig.setPassword("spring");
			
			HikariDataSource dataSource = new HikariDataSource(hikariConfig);
			
		return dataSource;
	}
	//(92)
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean(); //컨테이너 생성
		sqlSessionFactory.setDataSource(dataSource()); //DI
		
		return sqlSessionFactory.getObject();
	}
	
}
