package org.zerock.config;

import org.springframework.context.annotation.Configuration;

// 114
@Configuration
//@ComponentScan(basePackages = {"org.zerock.sample"})
//@MapperScan(basePackages = {"org.zerock.mapper"}) // (96)
public class RootConfig {
//	@Bean
//	public DataSource dataSource() {
//			HikariConfig hikariConfig = new HikariConfig();
////		hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
////			hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
//			hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
//			hikariConfig.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@localhost:1521:orcl");
//			hikariConfig.setUsername("spring");
//			hikariConfig.setPassword("spring");
//			
//			HikariDataSource dataSource = new HikariDataSource(hikariConfig);
//			
//		return dataSource;
//	}
//	//(92)
//	@Bean
//	public SqlSessionFactory sqlSessionFactory() throws Exception {
//		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean(); //컨테이너 생성
//		sqlSessionFactory.setDataSource(dataSource()); //DI
//		
//		return sqlSessionFactory.getObject();
//	}
	
}
