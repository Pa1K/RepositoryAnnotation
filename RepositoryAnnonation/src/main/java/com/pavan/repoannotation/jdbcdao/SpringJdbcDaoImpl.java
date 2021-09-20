package com.pavan.repoannotation.jdbcdao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SpringJdbcDaoImpl {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	String sql = "insert into student values(1,'pavan','india')";
	
	public void insertDataToDBUsingSpringJDBC() {
		jdbcTemplate.update(sql);
		System.out.println("sql query executed using spring jdbc ....");
	}
}
