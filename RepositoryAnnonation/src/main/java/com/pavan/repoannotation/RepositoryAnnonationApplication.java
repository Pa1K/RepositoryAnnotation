package com.pavan.repoannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration;
import org.springframework.dao.DataAccessException;

import com.pavan.repoannotation.jdbcdao.SpringJdbcDaoImpl;
import com.pavan.repoannotation.jpaDao.JPAImpl;

//@SpringBootApplication(exclude = PersistenceExceptionTranslationAutoConfiguration.class)
@SpringBootApplication
public class RepositoryAnnonationApplication implements CommandLineRunner {
	
	@Autowired
	private SpringJdbcDaoImpl springJdbcDaoImpl;
	
	@Autowired
	private JPAImpl jpaImpl;

	
	public static void main(String[] args) {
		SpringApplication.run(RepositoryAnnonationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		try {
			//springJdbcDaoImpl.insertDataToDBUsingSpringJDBC();	
			jpaImpl.insertDataToDBUsingSpringJPA();
		}
		catch(DataAccessException e){
			System.out.println(e);
			System.out.println(e.getClass());
			System.out.println(e.getMessage());
		}		
		
	}

}
